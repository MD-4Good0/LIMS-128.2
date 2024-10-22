package com.backend.lims.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.lims.model.Client;
import com.backend.lims.model.Request;
import com.backend.lims.model.Request.RequestStatus;
import com.backend.lims.repository.ClientRepository;
import com.backend.lims.repository.RequestRepository;

@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;
    
    @Autowired
    private ClientRepository clientRepository;
    
    public Request submitRequest(Request request, Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        request.setClient(client);
        request.setSubmissionDate(LocalDate.now());
        request.setRequestStatus(RequestStatus.PENDING_REVIEW);
        request.setCreatedAt(LocalDateTime.now());
        return requestRepository.save(request);
    }

    public List<Request> getPendingRequests() {
        return requestRepository.findByRequestStatus(RequestStatus.PENDING_REVIEW);
    }

    public Request approveRequest(Long requestId) {
        Request request = requestRepository.findById(requestId).orElseThrow(() -> new RuntimeException("Request not found"));
        request.setRequestStatus(RequestStatus.FOR_TESTING);
        request.setControlNumber(generateControlNumber(requestId));
        request.setUpdatedAt(LocalDateTime.now());
        return requestRepository.save(request);
    }

    public Request rejectRequest(Long requestId) {
        Request request = requestRepository.findById(requestId).orElseThrow(() -> new RuntimeException("Request not found"));
        request.setRequestStatus(RequestStatus.REJECTED);
        request.setUpdatedAt(LocalDateTime.now());
        return requestRepository.save(request);
    }
    
    public List<Request> getForReleaseRequests() {
        return requestRepository.findByRequestStatus(RequestStatus.FOR_RELEASE);
    }

    private String generateControlNumber(Long requestId) {
        return "CTRL-" + requestId + "-" + LocalDate.now().getYear();
    }
}
