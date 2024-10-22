package com.backend.lims.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.backend.lims.model.UnverifiedUser;
import com.backend.lims.model.User;
import com.backend.lims.model.Tester;
import com.backend.lims.repository.UserRepository;
import com.backend.lims.repository.TesterRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class TesterService {
	private final UserRepository userRepository;
	private final TesterRepository testerRepository;
	private final JavaMailSender javaMailSender;
	private List<User> loggedInTesters = new ArrayList<>();
	private List<User> loggedInAdmins = new ArrayList<>();

    @Autowired
    public TesterService(UserRepository userRepository, TesterRepository testerRepository, JavaMailSender javaMailSender) {
		this.userRepository = userRepository;
		this.testerRepository = testerRepository;
		this.javaMailSender = javaMailSender;
    }
    
    public String addUser(User user, Tester tester) {
    	if (userRepository.findByUsername(user.getUsername()) != null) {
            return "Username already exists. Please choose another one.";
        }
    	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPassword = bcrypt.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        user.setUserType("tester");
        userRepository.save(user);
        
        return "User registered successfully";
    }

    public Tester getTesterProfile(Long testerUserId) {
    	return testerRepository.findByUserId(testerUserId);
    }
    
    
    public Tester getTesterByUsername(String username) {
        User user = userRepository.findByUsername(username);

        for (User loggedInTesters : loggedInTesters) {
            if (loggedInTesters.getUserId().equals(user.getUserId())) {
                return getTesterProfile(user.getUserId());
            }
        }

        return null;
    }
  
    
    public Long getTesterUserIdByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user.getUserId();
        } else {
            return null; // Return null or handle the case when the user is not found
        }
    }

    
    public boolean login(String username, String password){
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        User user = userRepository.findByUsername(username);
           
        if (user != null && bcrypt.matches(password, user.getPassword())) {
            if ("tester".equalsIgnoreCase(user.getUserType())) {
                // This is a tester account, allow login

                // Get the associated tester
                Tester tester = testerRepository.findByUserId(user.getUserId());

                if (tester != null) {
                    loggedInTesters.add(user);
                    return true;
                } else {
                    // Handle the case where the tester is not found
                	   System.out.println("Tester associated with the user not found.");
                }
            } else {
                // This is not a tester account, deny login
            	   System.out.println("Login denied: Not a tester account.");
            }
        }
        
        // If the user is not found or the password doesn't match, deny login
        System.out.println("Login denied: Invalid credentials.");
		return false;
    }

    public String changePassword(String username, String oldPassword, String newPassword) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        User user = userRepository.findByUsername(username);

        if( user != null && bcrypt.matches(oldPassword, user.getPassword())) {
            String encryptedPassword = bcrypt.encode(newPassword);
            user.setPassword(encryptedPassword);
            userRepository.save(user);
            return "Successfully changed password";
        }
        return "Failed to change password";
    }
    

    public void logout(String username) {
        // Remove the logged-out patient from the list based on the username
        loggedInTesters.removeIf(user -> user.getUsername().equals(username));
    }
    
    public void adminlogout(String username) {
        // Remove the logged-out patient from the list based on the username
        loggedInAdmins.removeIf(user -> user.getUsername().equals(username));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public void setLoggedInTester(User loggedInTester) {
    	loggedInTesters.add(loggedInTester);    
    }
    
    public List<Long> getLoggedInTesterUserIds() {
        // Return a list of user IDs for all logged-in patients
        return loggedInTesters.stream()
                .map(User::getUserId)
                .collect(Collectors.toList());
    }



    public void setLoggedInAdmin(User loggedInAdmin) {
    	loggedInTesters.add(loggedInAdmin);
    }
    


    public List<Tester> getAllUsers() {
        // Retrieve all registered users from the UserRepository
        return testerRepository.findAll();
    }
    
    public String updateUserAndTesterDetails(String username, User user, Tester tester) {

        if (loggedInTesters == null) {
            return "User not logged in";
        }

        // Find the logged-in user based on the username
        Optional<User> optionalUser = loggedInTesters.stream()
                .filter(loggedInUser -> loggedInUser.getUsername().equals(username))
                .findFirst();

        // Check if the user is found
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            Long userId = existingUser.getUserId(); // Get the userId from the logged-in user

            // Find existing user and tester by userId
            User existingUserFromDb = userRepository.findByUserId(userId);
            Tester existingTesterFromDb = testerRepository.findByUserId(userId);

            if (existingUserFromDb != null && existingTesterFromDb != null) {
                // Update user details
                existingUserFromDb.setFirstName(user.getFirstName());
                existingUserFromDb.setMiddleName(user.getMiddleName());
                existingUserFromDb.setLastName(user.getLastName());
                existingUserFromDb.setContactNumber(user.getContactNumber());
                existingUserFromDb.setEmail(user.getEmail());

                // Update tester details
                existingTesterFromDb.setSpecialization(tester.getSpecialization());
                existingTesterFromDb.setLicenseNumber(tester.getLicenseNumber());
                // Save updated user and tester details
                userRepository.save(existingUserFromDb);
                testerRepository.save(existingTesterFromDb);

                return "User and tester details updated successfully";
            } else {
                return "User or tester not found for the given ID";
            }
        } else {
            return "User not found";
        }
    }

    public String deactivateUser(Long userId) {
        User userToDeactivate = userRepository.findByUserId(userId);
        if(userToDeactivate != null) {
            userToDeactivate.setDeletionStatus("Deleted");
            userRepository.save(userToDeactivate);
            return "Tester deletion status set to Deleted";
        } else {
            return "User not found";
        }
    }

}
