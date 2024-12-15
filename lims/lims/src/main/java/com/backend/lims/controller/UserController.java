package com.backend.lims.controller;

import com.backend.lims.model.User;
import com.backend.lims.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("identifier") String identifier,
                                        @RequestParam("password") String password) {
        String username = userService.login(identifier, password);

        if (!username.startsWith("Login denied")) {
            return ResponseEntity.ok(username);
        } else {
            // If the login failed or if the user is deleted, return UNAUTHORIZED status
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(username);
        }
    }
     */

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String identifier, @RequestParam String password) {
        String loginResult = userService.login(identifier, password);

        // Check if login was successful and TFA is initiated
        if (loginResult.contains("Login denied") || loginResult.equals("Invalid credentials")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResult);
        } else if (loginResult.equals("User not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        // OTP has been sent to email, prompt user to verify
        return ResponseEntity.ok("TFA initiated. Please check your email for the OTP.");
    }

    // Endpoint to verify OTP and complete login
    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOTP(@RequestParam String username, @RequestParam String otp) {
        String verifyResult = userService.verifyOTP(username, otp);

        // Verify OTP result and complete login if successful
        if (!verifyResult.equals("Invalid or expired OTP.")) {
            System.out.println(verifyResult);
            return ResponseEntity.ok(verifyResult);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not allowed");
    }
}