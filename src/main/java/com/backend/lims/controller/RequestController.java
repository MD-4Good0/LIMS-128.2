package com.backend.lims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.lims.model.Request;
import com.backend.lims.service.RequestService;

@RestController
@RequestMapping("/api/requests")
public class RequestController {
    
    @Autowired
    private RequestService requestService;

    // Submit a new request
    @PostMapping("/submit/{clientId}")
    public ResponseEntity<Request> submitRequest(@RequestBody Request request, @PathVariable Long clientId) {
        return new ResponseEntity<>(requestService.submitRequest(request, clientId), HttpStatus.CREATED);
    }

    // Get pending requests (for staff review)
    @GetMapping("/pending")
    public ResponseEntity<List<Request>> getPendingRequests() {
        return new ResponseEntity<>(requestService.getPendingRequests(), HttpStatus.OK);
    }

    // Approve request (For testing)
    @PutMapping("/approve/{requestId}")
    public ResponseEntity<Request> approveRequest(@PathVariable Long requestId) {
        return new ResponseEntity<>(requestService.approveRequest(requestId), HttpStatus.OK);
    }

    // Reject request
    @PutMapping("/reject/{requestId}")
    public ResponseEntity<Request> rejectRequest(@PathVariable Long requestId) {
        return new ResponseEntity<>(requestService.rejectRequest(requestId), HttpStatus.OK);
    }

    // Get requests for release
    @GetMapping("/for-release")
    public ResponseEntity<List<Request>> getForReleaseRequests() {
        return new ResponseEntity<>(requestService.getForReleaseRequests(), HttpStatus.OK);
    }
}