package com.backend.lims.service;

import com.backend.lims.model.User;
import com.backend.lims.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final StaffRepository staffRepository;
    private final TesterRepository testerRepository;
    private List<User> loggedInClients = new ArrayList<>();
    private List<User> loggedInStaff = new ArrayList<>();
    private List<User> loggedInTesters = new ArrayList<>();
    private JavaMailSender javaMailSender;
    private static final int OTP_LENGTH = 6;
    private final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    @Autowired
    public UserService(UserRepository userRepository, ClientRepository clientRepository, StaffRepository staffRepository, TesterRepository testerRepository, List<User> loggedInClients, List<User> loggedInStaff, List<User> loggedInTesters, JavaMailSender javaMailSender) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.staffRepository = staffRepository;
        this.testerRepository = testerRepository;
        this.loggedInClients = loggedInClients;
        this.loggedInStaff = loggedInStaff;
        this.loggedInTesters = loggedInTesters;
        this.javaMailSender = javaMailSender;
    }

    private String generateOTP() {
        SecureRandom random = new SecureRandom();
        StringBuilder otp = new StringBuilder(OTP_LENGTH);
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(random.nextInt(10));  // Generate a random digit from 0 to 9
        }
        return otp.toString();
    }

    // Initiate TFA by generating and sending an OTP
    private String initiateTFA(User user) {
        String otp = generateOTP();
        user.setOtp(otp);
        user.setOtpTimestamp(LocalDateTime.now());
        userRepository.save(user);

        // Send OTP to user's email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Your OTP for Login");
        message.setText("Your OTP is: " + otp + ". It will expire in 5 minutes.");
        javaMailSender.send(message);

        return "OTP sent to email.";
    }

    // Verify the OTP
    public String verifyOTP(String identifier, String inputOtp) {
        User user = userRepository.findByUsername(identifier);
        if (user == null) {
            user = userRepository.findByEmail(identifier);
        }

        if (user != null && user.getOtp() != null && user.getOtpTimestamp() != null) {
            if (user.getOtp().equals(inputOtp) && user.getOtpTimestamp().plusMinutes(5).isAfter(LocalDateTime.now())) {
                user.setOtp(null);
                user.setOtpTimestamp(null);
                userRepository.save(user);
                return user.getUserType().toLowerCase() + "/" + user.getUserId().toString();
            }
        }
        return "Invalid or expired OTP.";
    }

    // Login method that checks user type and initiates TFA
    public String login(String identifier, String password) {
        User user = userRepository.findByUsername(identifier);
        if (user == null) {
            user = userRepository.findByEmail(identifier);
        }

        if (user != null && bcrypt.matches(password, user.getPassword())) {
            if ("deleted".equalsIgnoreCase(user.getDeletionStatus())) {
                return "Login denied: Account has been deleted.";
            }

            initiateTFA(user);  // Initiate TFA for the user
            return user.getUserType().toLowerCase() + "/" + user.getUserId().toString();
        }

        return "Invalid credentials";
    }

    /*
    public String clientLogin(String identifier, String password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        User user = userRepository.findByUsername(identifier);

        // If no user is found with the username, try to find by email
        if (user == null) {
            user = userRepository.findByEmail(identifier);
        }

        if (user != null && bcrypt.matches(password, user.getPassword())) {
            if ("CLIENT".equalsIgnoreCase(user.getUserType())) {
                // Check if the user is marked as deleted
                if ("deleted".equalsIgnoreCase(user.getDeletionStatus())) {
                    return "Login denied: Account has been deleted.";
                }

                // This is a patient account, allow login
                loggedInClients.add(user);
                return "Login successful";
            } else {
                // This is not a dentist account, deny login and print an error message
                return "Login denied: Not a client account.";
            }
        }

        // If the user is not found or the password doesn't match, deny login
        return "Login denied: Invalid credentials.";
    }

    public String testerLogin(String identifier, String password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        User user = userRepository.findByUsername(identifier);

        // If no user is found with the username, try to find by email
        if (user == null) {
            user = userRepository.findByEmail(identifier);
        }

        if (user != null && bcrypt.matches(password, user.getPassword())) {
            if ("TESTER".equalsIgnoreCase(user.getUserType())) {
                // Check if the user is marked as deleted
                if ("deleted".equalsIgnoreCase(user.getDeletionStatus())) {
                    return "Login denied: Account has been deleted.";
                }

                // This is a patient account, allow login
                loggedInTesters.add(user);
                return "Login successful";
            } else {
                // This is not a dentist account, deny login and print an error message
                return "Login denied: Not a tester account.";
            }
        }

        // If the user is not found or the password doesn't match, deny login
        return "Login denied: Invalid credentials.";
    }

    public String staffLogin(String identifier, String password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        User user = userRepository.findByUsername(identifier);

        // If no user is found with the username, try to find by email
        if (user == null) {
            user = userRepository.findByEmail(identifier);
        }

        if (user != null && bcrypt.matches(password, user.getPassword())) {
            if ("STAFF".equalsIgnoreCase(user.getUserType())) {
                // Check if the user is marked as deleted
                if ("deleted".equalsIgnoreCase(user.getDeletionStatus())) {
                    return "Login denied: Account has been deleted.";
                }

                // This is a patient account, allow login
                loggedInStaff.add(user);
                return "Login successful";
            } else {
                // This is not a dentist account, deny login and print an error message
                return "Login denied: Not a tester account.";
            }
        }

        // If the user is not found or the password doesn't match, deny login
        return "Login denied: Invalid credentials.";
    }

    public String login(String identifier, String password) {
        User user = userRepository.findByUsername(identifier);

        // If no user is found with the username, try to find by email
        if (user == null) {
            user = userRepository.findByEmail(identifier);
        }

        // Assumed that user exists
        if (user != null) {
            if ("CLIENT".equalsIgnoreCase(user.getUserType())) { // User is a client
                String result = clientLogin(identifier, password); // Call clientLogin function
                if (result.equals("Login successful")) {
                    return user.getUserType().toLowerCase() + "/" + user.getUserId().toString(); // Return username upon successful login
                }
                return result; // Return the result from patientService
            } else if ("TESTER".equalsIgnoreCase(user.getUserType())) {
                String result = testerLogin(identifier, password);
                if (result.equals("Login successful")) {
                    return user.getUserType().toLowerCase() + "/" + user.getUserId().toString(); // Return username upon successful login
                }
                return result; // Return the result from dentistService
            } else if ("STAFF".equalsIgnoreCase(user.getUserType())) {
                String result = staffLogin(identifier, password);
                if (result.equals("Login successful")) {
                    return user.getUserType().toLowerCase() + "/" + user.getUserId().toString(); // Return username upon successful login
                }
                return result; // Return the result from dentistService
            } else {
                return "Invalid user type";
            }
        } else {
            return "User not found";
        }
    }

     */
}