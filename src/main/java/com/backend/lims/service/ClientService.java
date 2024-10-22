package com.backend.lims.service;

import com.backend.lims.dto.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.backend.lims.model.User;
import com.backend.lims.model.Client;
import com.backend.lims.repository.UserRepository;
import com.backend.lims.repository.ClientRepository;
import com.backend.lims.model.UnverifiedClient;
import com.backend.lims.model.UnverifiedUser;
import com.backend.lims.repository.UnverifiedClientRepository;
import com.backend.lims.repository.UnverifiedUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ClientService {
	private final UnverifiedUserRepository unverifiedUserRepository;
	private final UnverifiedClientRepository unverifiedClientRepository;
	private final UserRepository userRepository;
	private final ClientRepository clientRepository;
	private final JavaMailSender javaMailSender;
    private List<User> loggedInClients = new ArrayList<>();

    @Autowired
    public ClientService(UnverifiedUserRepository unverifiedUserRepository,UnverifiedClientRepository unverifiedClientRepository, UserRepository userRepository, ClientRepository clientRepository, JavaMailSender javaMailSender) {
        this.unverifiedUserRepository = unverifiedUserRepository;
		this.unverifiedClientRepository = unverifiedClientRepository;
		this.userRepository = userRepository;
		this.clientRepository = clientRepository;
		this.javaMailSender = javaMailSender;
    }
    
    public void sendVerification(String email, Integer code) {
        String subject = "Account Verification";
        sendVerificationEmail(email, subject, code);
	}

    public String addUser(User user, Client client) {
        User u = userRepository.findByUsername(user.getUsername());
        User uemail = userRepository.findByEmail(user.getEmail());
        UnverifiedUser unv = unverifiedUserRepository.findByUsername(user.getUsername());
        UnverifiedUser unvemail = unverifiedUserRepository.findByEmail(user.getEmail());
        
        if (u != null || unv != null) {
            return "Username is already in use.";
        } else {
            if (uemail != null) {
                if (uemail.getDeletionStatus() != "Deleted") return "Email is already in use by a non-Deleted Account.";
            }
            if (unvemail != null) {
                if (unvemail.getDeletionStatus() != "Deleted") return "Email is already in use by a non-Deleted Account.";
            }
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            String encryptedPassword = bcrypt.encode(user.getPassword());
            user.setPassword(encryptedPassword);
            int otp = generateVerificationCode();

            sendVerification(user.getEmail(), otp);

            UnverifiedUser newUser = new UnverifiedUser(user, otp);
            UnverifiedClient newClient = new UnverifiedClient(client);

            // Save the unverified user and client to their respective repositories
            unverifiedUserRepository.save(newUser);
            newClient.setUserId(newUser.getUserId());
            unverifiedClientRepository.save(newClient);

            return "User registered successfully";
        }
    }

    
    public boolean verifyUser(String email, Integer otp) {
    	UnverifiedUser unvUser = unverifiedUserRepository.findByEmailAndOtp(email, otp);
    	if (unvUser != null) {
    		Long userId = unvUser.getUserId();
    		UnverifiedClient unvClient = unverifiedClientRepository.findByUserId(userId);
    		User user = new User(unvUser);
    		userRepository.save(user);
    		
    		Client client = new Client(unvClient);
    		clientRepository.save(client);
    		
    		unverifiedClientRepository.deleteById(userId);
    		unverifiedUserRepository.deleteById(userId);
    		return true;
    	} else {
    		return false;
    	}
	}

    
    public boolean login(String username, String password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        User user = userRepository.findByUsername(username);
        
        if (user != null && bcrypt.matches(password, user.getPassword())) {
            if ("client".equalsIgnoreCase(user.getUserType())) {
                // This is a client account, allow login
               loggedInClients.add(user);
                return true;
            } else {
                // This is not a client account, deny login and print an error message
                System.out.println("Login denied: Not a client account.");
                return false;
            }
        }
        
        // If the user is not found or the password doesn't match, deny login
        System.out.println("Login denied: Invalid credentials.");
        return false;
    }

    public String changePassword(String username, String oldPassword, String newPassword) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        User user = userRepository.findByUsername(username);


        if(user != null && bcrypt.matches(oldPassword, user.getPassword())) {
            String encryptedPassword = bcrypt.encode(newPassword);
            user.setPassword(encryptedPassword);
            userRepository.save(user);
            return "Successfully changed password";
        }
        return "Failed to change password";
    }


    public void logout(String username) {
        // Remove the logged-out client from the list based on the username
        loggedInClients.removeIf(user -> user.getUsername().equals(username));
    }

    
    public Client getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            // Handle the case where the user is not found
            System.out.println("User not found for username: " + username);
            return null; // or throw an exception if appropriate
        }

        for (User loggedInClient : loggedInClients) {
            if (loggedInClient.getUserId().equals(user.getUserId())) {
                return getClientProfile(user.getUserId());
            }
        }

        return null;
    }
    

    public Long getUserIdByUsername(String username) {
        User user = userRepository.findByUsername(username);

        if (user != null) {
            for (User loggedInClient : loggedInClients) {
                if (loggedInClient.getUserId().equals(user.getUserId())) {
                    return user.getUserId();
                }
            }
        }

        return null;
    }

    public ClientDTO getClientDetails(Long clientUserId) {
        Client client = clientRepository.findByUserId(clientUserId);
        if (client != null) {
            return new ClientDTO(
                    client.getUser().getUsername(),
                    client.getUser().getContactNumber(),
                    client.getUser().getEmail(),
                    client.getCompanyName(),
                    client.getLtoNo(),
                    client.getClassification()
            );
        }

        return null;
    }


    public Client getClientProfile(Long clientUserId) {
        return clientRepository.findByUserId(clientUserId);
    }

    public void setLoggedInClient(User loggedInClient) {
        // Add the logged-in client to the list
        loggedInClients.add(loggedInClient);
    }

    public List<Long> getLoggedInClientUserIds() {
        // Return a list of user IDs for all logged-in clients
        return loggedInClients.stream()
                .map(User::getUserId)
                .collect(Collectors.toList());
    }



	private void sendVerificationEmail(String to, String subject, Integer code) {
        SimpleMailMessage message = new SimpleMailMessage();
        String link = "http://localhost:8080/verify?email=" + to + "&otp=" + code;
        message.setTo(to);
        message.setSubject(subject);
        message.setText("To verify your account, please enter this code: " + String.valueOf(code) + "\n\nOr follow this link in your browser: " + link);
        javaMailSender.send(message);
    }
    private Integer generateVerificationCode() {
    	Random random = new Random();
        int min = 100000;
        int max = 999999;
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber;
    }
    
    public List<Client> getAllUsers() {
        // Retrieve all registered users from the UserRepository
        return clientRepository.findAll();
    }
    public String updateUserAndClientDetails(String username, User user, Client client) {
        // Check if the user is logged in
        if (loggedInClients == null) {
            return "User not logged in";
        }

        // Find the logged-in user based on the username
        Optional<User> optionalUser = loggedInClients.stream()
                .filter(loggedInUser -> loggedInUser.getUsername().equals(username))
                .findFirst();

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            Long userId = existingUser.getUserId();

            // Update user details
            existingUser.setFirstName(user.getFirstName());
            existingUser.setMiddleName(user.getMiddleName());
            existingUser.setLastName(user.getLastName());
            existingUser.setContactNumber(user.getContactNumber());
            existingUser.setEmail(user.getEmail());

            // Find the client based on the user ID
            Client existingClient = clientRepository.findByUserId(userId);

            if (existingClient != null) {
                // Update client details
                existingClient.setLtoNo(client.getLtoNo());
                existingClient.setCompanyName(client.getCompanyName());
                existingClient.setClassification(client.getClassification());

                // Save updated user and client details
                userRepository.save(existingUser);
                clientRepository.save(existingClient);

                return "User and client details updated successfully";
            } else {
                return "Client not found for the given user ID";
            }
        } else {
            return "User not found for the given username";
        }
    }

    public String deactivateUser(Long userId) {
        User userToDeactivate = userRepository.findByUserId(userId);
        UnverifiedUser unverifiedUserToDeactivate = unverifiedUserRepository.findByUserId(userId);
        if(userToDeactivate != null && unverifiedUserToDeactivate == null) {
            userToDeactivate.setDeletionStatus("Deleted");
            userRepository.save(userToDeactivate);
            return "Client deletion status set to Deleted";
        } else if(userToDeactivate == null && unverifiedUserToDeactivate != null) {
            unverifiedUserToDeactivate.setDeletionStatus("Deleted");
            unverifiedUserRepository.save(unverifiedUserToDeactivate);
            return "Unverified Client deletion status set to Deleted";
        } else {
            return "User not found";
        }
    }

	
	
}
