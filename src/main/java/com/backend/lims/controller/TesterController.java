package com.backend.lims.controller;

import com.backend.lims.model.Tester;
import com.backend.lims.model.User;
import com.backend.lims.model.UserTesterRequest;
import com.backend.lims.model.UserTesterRequest;
import com.backend.lims.service.TesterService;
import com.backend.lims.service.TesterService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public class TesterController {
	private final TesterService testerService;

    @Autowired
    public TesterController(TesterService testerService) {
        this.testerService = testerService;
    }

    @PostMapping("/tester")
    public ResponseEntity<String> addUser(@RequestBody UserTesterRequest userTesterRequest) {
    	 User user = userTesterRequest.getUser();
         Tester tester = userTesterRequest.getTester();
    	return ResponseEntity.ok(testerService.addUser(user, tester));
    }
  
	 @GetMapping("/getTesterUserId")
	    public ResponseEntity<Long> getTesterUserId(@RequestParam String username) {
	        Long testerUserId = testerService.getTesterUserIdByUsername(username);
	        if (testerUserId != null) {
	            return ResponseEntity.ok(testerUserId);
	        } else {
	            // Handle the case when the tester's user is not found
	            return ResponseEntity.notFound().build();
	        }
	    }

    
    @GetMapping("/testerdetails/{username}")
    public ResponseEntity<Tester> getTesterByUsername(@PathVariable String username) {
    	Tester user = testerService.getTesterByUsername(username);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<Tester>> viewAllUsers() {
        List<Tester> allUsers = testerService.getAllUsers();
        if (allUsers != null && !allUsers.isEmpty()) {
            return ResponseEntity.ok(allUsers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
    @PutMapping("/edittester/{username}")
    public ResponseEntity<String> updateDetails(@RequestBody UserTesterRequest userTesterRequest, @PathVariable String username) {
    	User user = userTesterRequest.getUser();
        Tester tester = userTesterRequest.getTester();
        String result = testerService.updateUserAndTesterDetails(username, user, tester);
        if ("User and tester details updated successfully".equals(result)) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/testerlogin")
    public ResponseEntity<String> login(@RequestParam("username") String username,
                                        @RequestParam("password") String password) {

        if (testerService.login(username, password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

    @PostMapping("/testerlogout/{username}")
    public ResponseEntity<String> logout(@PathVariable String username) {

        testerService.logout(username);
        return ResponseEntity.ok("Logged out successfully");
    }
    
  
    @PostMapping("/changePass/tester")
    public ResponseEntity<String> changePassword(
            @RequestParam ("username") String username,
            @RequestParam ("oldPassword") String oldPassword,
            @RequestParam ("newPassword") String newPassword) {

        return ResponseEntity.ok(testerService.changePassword(username, oldPassword, newPassword));
    }
    
 

    @DeleteMapping("/tester")
    public ResponseEntity<String> deleteUser(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(testerService.deactivateUser(userId));
    }

}
