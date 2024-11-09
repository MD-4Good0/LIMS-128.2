package com.backend.lims.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.backend.lims.model.UnverifiedUser;
import com.backend.lims.model.User;
import com.backend.lims.model.Staff;
import com.backend.lims.repository.UserRepository;
import com.backend.lims.repository.StaffRepository;

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
public class StaffService {
	private final UserRepository userRepository;
	private final StaffRepository staffRepository;
	private final JavaMailSender javaMailSender;
	private List<User> loggedInStaffs = new ArrayList<>();
	private List<User> loggedInAdmins = new ArrayList<>();



    @Autowired
    public StaffService(UserRepository userRepository, StaffRepository staffRepository, JavaMailSender javaMailSender) {
		this.userRepository = userRepository;
		this.staffRepository = staffRepository;
		this.javaMailSender = javaMailSender;
    }
    
    public String addUser(User user, Staff staff) {
    	if (userRepository.findByUsername(user.getUsername()) != null) {
            return "Username already exists. Please choose another one.";
        }
    	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPassword = bcrypt.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        user.setUserType("staff");
        userRepository.save(user);
        
        return "User registered successfully";
    }

    public Staff getStaffProfile(Long staffUserId) {
    	return staffRepository.findByUserId(staffUserId);
    }
    
    
    public Staff getStaffByUsername(String username) {
        User user = userRepository.findByUsername(username);

        for (User loggedInStaffs : loggedInStaffs) {
            if (loggedInStaffs.getUserId().equals(user.getUserId())) {
                return getStaffProfile(user.getUserId());
            }
        }

        return null;
    }
  
    
    public Long getStaffUserIdByUsername(String username) {
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
            if ("staff".equalsIgnoreCase(user.getUserType())) {
                // This is a staff account, allow login

                // Get the associated staff
                Staff staff = staffRepository.findByUserId(user.getUserId());

                if (staff != null) {
                    loggedInStaffs.add(user);
                    return true;
                } else {
                    // Handle the case where the staff is not found
                	   System.out.println("Staff associated with the user not found.");
                }
            } else {
                // This is not a staff account, deny login
            	   System.out.println("Login denied: Not a staff account.");
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
        loggedInStaffs.removeIf(user -> user.getUsername().equals(username));
    }
    
    public void adminlogout(String username) {
        // Remove the logged-out patient from the list based on the username
        loggedInAdmins.removeIf(user -> user.getUsername().equals(username));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public void setLoggedInStaff(User loggedInStaff) {
    	loggedInStaffs.add(loggedInStaff);    
    }
    
    public List<Long> getLoggedInStaffUserIds() {
        // Return a list of user IDs for all logged-in patients
        return loggedInStaffs.stream()
                .map(User::getUserId)
                .collect(Collectors.toList());
    }



    public void setLoggedInAdmin(User loggedInAdmin) {
    	loggedInStaffs.add(loggedInAdmin);
    }
    

    public List<Staff> getAllUsers() {
        // Retrieve all registered users from the UserRepository
        return staffRepository.findAll();
    }
    
    public String updateUserAndStaffDetails(String username, User user, Staff staff) {

        if (loggedInStaffs == null) {
            return "User not logged in";
        }

        // Find the logged-in user based on the username
        Optional<User> optionalUser = loggedInStaffs.stream()
                .filter(loggedInUser -> loggedInUser.getUsername().equals(username))
                .findFirst();

        // Check if the user is found
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            Long userId = existingUser.getUserId(); // Get the userId from the logged-in user

            // Find existing user and staff by userId
            User existingUserFromDb = userRepository.findByUserId(userId);
            Staff existingStaffFromDb = staffRepository.findByUserId(userId);

            if (existingUserFromDb != null && existingStaffFromDb != null) {
                // Update user details
                existingUserFromDb.setFirstName(user.getFirstName());
                existingUserFromDb.setMiddleName(user.getMiddleName());
                existingUserFromDb.setLastName(user.getLastName());
                existingUserFromDb.setContactNumber(user.getContactNumber());
                existingUserFromDb.setEmail(user.getEmail());
             

                // Save updated user and staff details
                userRepository.save(existingUserFromDb);
                staffRepository.save(existingStaffFromDb);

                return "User and staff details updated successfully";
            } else {
                return "User or staff not found for the given ID";
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
