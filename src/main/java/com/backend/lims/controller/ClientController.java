package com.backend.lims.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.backend.lims.model.Client;
import com.backend.lims.model.User;
import com.backend.lims.model.UserClientRequest;
import com.backend.lims.service.ClientService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class ClientController {
	private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    public ResponseEntity<Map<String, String>> addUser(@RequestBody UserClientRequest userClientRequest) {
        User user = userClientRequest.getUser();
        Client client = userClientRequest.getClient();
        
        // Assuming that addUser returns a success message
        String message = clientService.addUser(user, client);
        
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/clientview/{clientUserId}")
    public Client getClientProfile(@PathVariable Long clientUserId) {
        return clientService.getClientProfile(clientUserId);
    }
    
    @GetMapping("/clientdetails/{username}")
    public ResponseEntity<Client> getUserByUsername(@PathVariable String username) {
        Client user = clientService.getUserByUsername(username);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/clientuserid/{username}")
    public Long getUserIdByUsername(@PathVariable String username) {
        return clientService.getUserIdByUsername(username);
    }

    @PutMapping("/editpatient/{username}")
    public ResponseEntity<String> updateDetails(@PathVariable String username, @RequestBody UserClientRequest userClientRequest) {
    	User user = userClientRequest.getUser();
    	Client client = userClientRequest.getClient();
        String result = clientService.updateUserAndClientDetails(username, user, client);
        if ("User and patient details updated successfully".equals(result)) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/clientverify")
    public ResponseEntity<String> verifyUser(@RequestParam("email") String email,
            								@RequestParam("otp") Integer otp) {
    	if (clientService.verifyUser(email, otp)) {
    		return ResponseEntity.ok("Successful verification.");
    	} else {
    		return ResponseEntity.ok("Unsuccessful verification.");
    	}
    }

    @PostMapping("/clientlogin")
    public ResponseEntity<String> login(@RequestParam("username") String username,
                                        @RequestParam("password") String password) {

        if (clientService.login(username, password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

    @PostMapping("/clientlogout/{username}")
    public ResponseEntity<String> logout(@PathVariable String username) {
        clientService.logout(username);
        return ResponseEntity.ok("Logged out successfully");
    }

    @PostMapping("/changePass/client")
    public ResponseEntity<String> changePassword(
            @RequestParam ("username") String username,
            @RequestParam ("oldPassword") String oldPassword,
            @RequestParam ("newPassword") String newPassword) {
        return ResponseEntity.ok(clientService.changePassword(username, oldPassword, newPassword));
    }
    
    
    @GetMapping("/allclients")
    public ResponseEntity<List<Client>> viewAllUsers() {
        List<Client> allUsers = clientService.getAllUsers();
        if (allUsers != null && !allUsers.isEmpty()) {
            return ResponseEntity.ok(allUsers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/clients")
    public ResponseEntity<String> deleteUser(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(clientService.deactivateUser(userId));
    }
}
