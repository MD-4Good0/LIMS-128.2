package com.backend.lims.service;

import com.backend.lims.model.Tester;
import com.backend.lims.model.User;
import com.backend.lims.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

    @Autowired
    public UserService(UserRepository userRepository, ClientRepository clientRepository, StaffRepository staffRepository, TesterRepository testerRepository, List<User> loggedInClients, List<User> loggedInStaff, List<User> loggedInTesters) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.staffRepository = staffRepository;
        this.testerRepository = testerRepository;
        this.loggedInClients = loggedInClients;
        this.loggedInStaff = loggedInStaff;
        this.loggedInTesters = loggedInTesters;
    }

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
            if ("TESTER".equalsIgnoreCase(user.getUserType())) {
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

        if (user != null) {
            if ("CLIENT".equalsIgnoreCase(user.getUserType())) {
                String result = clientLogin(identifier, password);
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
}
