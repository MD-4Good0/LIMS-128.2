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
import java.util.List;

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

    public String checkIfUserExists(String identifier) {
        User user = userRepository.findByEmail(identifier);

        if (user == null) {
            user = userRepository.findByEmail(identifier);
        }

        if (user != null) {
            sendOtpForPasswordReset(user.getEmail());
            return "User found.";
        }
        return "User does not exist.";
    }

    public void sendOtpForPasswordReset(String identifier) {
        User user = userRepository.findByEmail(identifier);

        // Generate OTP and save to the user record
        String otp = generateOTP();
        user.setOtp(otp);
        user.setOtpTimestamp(LocalDateTime.now());
        userRepository.save(user);

        // Send OTP to user's email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Password Reset OTP");
        message.setText("Your OTP for password reset is: " + otp + ". It will expire in 5 minutes.");
        javaMailSender.send(message);
    }

    public String verifyOtpForPasswordReset(String identifier, String inputOtp) {
        User user = userRepository.findByEmail(identifier);
        if (user == null || user.getOtp() == null || user.getOtpTimestamp() == null) {
            return "Invalid OTP.";
        }

        if (user.getOtp().equals(inputOtp) && user.getOtpTimestamp().plusMinutes(5).isAfter(LocalDateTime.now())) {
            // Invalidate OTP after successful verification
            user.setOtp(null);
            user.setOtpTimestamp(null);
            userRepository.save(user);
            return "OTP verified.";
        }

        return "Invalid or expired OTP.";
    }

    public String changePassword(String identifier, String newPassword) {
        User user = userRepository.findByEmail(identifier);
        if (user == null) {
            return "User does not exist.";
        }

        // Update password
        user.setPassword(bcrypt.encode(newPassword));
        userRepository.save(user);

        return "Password changed successfully.";
    }
}