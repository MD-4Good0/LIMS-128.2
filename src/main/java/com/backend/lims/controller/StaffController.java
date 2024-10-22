package com.backend.lims.controller;

import com.backend.lims.model.Staff;
import com.backend.lims.model.User;
import com.backend.lims.model.UserStaffRequest;
import com.backend.lims.service.StaffService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StaffController {
	private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("/staff")
    public ResponseEntity<String> addUser(@RequestBody UserStaffRequest userStaffRequest) {
    	 User user = userStaffRequest.getUser();
         Staff staff = userStaffRequest.getStaff();
    	return ResponseEntity.ok(staffService.addUser(user, staff));
    }
    
	 @GetMapping("/getStaffUserId")
	    public ResponseEntity<Long> getStaffUserId(@RequestParam String username) {
	        Long staffUserId = staffService.getStaffUserIdByUsername(username);
	        if (staffUserId != null) {
	            return ResponseEntity.ok(staffUserId);
	        } else {
	            // Handle the case when the staff's user is not found
	            return ResponseEntity.notFound().build();
	        }
	    }

    
    @GetMapping("/staffdetails/{username}")
    public ResponseEntity<Staff> getStaffByUsername(@PathVariable String username) {
    	Staff user = staffService.getStaffByUsername(username);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<Staff>> viewAllUsers() {
        List<Staff> allUsers = staffService.getAllUsers();
        if (allUsers != null && !allUsers.isEmpty()) {
            return ResponseEntity.ok(allUsers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
    @PutMapping("/editstaff/{username}")
    public ResponseEntity<String> updateDetails(@RequestBody UserStaffRequest userStaffRequest, @PathVariable String username) {
    	User user = userStaffRequest.getUser();
        Staff staff = userStaffRequest.getStaff();
        String result = staffService.updateUserAndStaffDetails(username, user, staff);
        if ("User and staff details updated successfully".equals(result)) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/stafflogin")
    public ResponseEntity<String> login(@RequestParam("username") String username,
                                        @RequestParam("password") String password) {

        if (staffService.login(username, password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

    @PostMapping("/stafflogout/{username}")
    public ResponseEntity<String> logout(@PathVariable String username) {

        staffService.logout(username);
        return ResponseEntity.ok("Logged out successfully");
    }
    
  
    @PostMapping("/changePass/staff")
    public ResponseEntity<String> changePassword(
            @RequestParam ("username") String username,
            @RequestParam ("oldPassword") String oldPassword,
            @RequestParam ("newPassword") String newPassword) {

        return ResponseEntity.ok(staffService.changePassword(username, oldPassword, newPassword));
    }
    
 

    @DeleteMapping("/staff")
    public ResponseEntity<String> deleteUser(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(staffService.deactivateUser(userId));
    }

}
