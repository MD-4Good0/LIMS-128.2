	package com.backend.lims.service;
	
	import java.time.LocalDate;
	import java.time.LocalDateTime;
	import java.util.List;
	import java.time.format.DateTimeFormatter;
	import java.util.stream.Collectors;

	import com.backend.lims.dto.RequestDTO;
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
	
	    public RequestService(RequestRepository requestRepository, ClientRepository clientRepository) {
	        this.requestRepository = requestRepository;
	        this.clientRepository = clientRepository;
	    }
	
	    public Request submitRequest(Request request, Long clientId) {
	        // Fetch client by clientId
	        Client client = clientRepository.findById(clientId)
	                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + clientId));
	
	        // Set the client information
	        request.setClient(client);
	
	        // Set initial request status to PENDING_REVIEW
	        request.setRequestStatus(Request.RequestStatus.PENDING_REVIEW);
	
	        // Set submission date if not already set
	        if (request.getSubmissionDate() == null) {
	            request.setSubmissionDate(LocalDate.now());
	        }
	
	        // Set createdAt and updatedAt timestamps
	        request.setCreatedAt(LocalDateTime.now());
	        request.setUpdatedAt(LocalDateTime.now());
	
	        // Save the request to the database
	        return requestRepository.save(request);
	    }
	
	    public List<Request> getPendingRequests() {
	        return requestRepository.findByRequestStatus(RequestStatus.PENDING_REVIEW);
	    }
	
	    public Request getSpecificPendingRequest(Long requestId) {
	        return requestRepository.findByRequestId(requestId);
	    }
	
	    public Request approveRequest(Long requestId) {
	        Request request = requestRepository.findById(requestId).orElseThrow(() -> new RuntimeException("Request not found"));
	        request.setRequestStatus(RequestStatus.FOR_TESTING);
	        request.setControlNumber(generateControlNumber());
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
	
	    private String generateControlNumber() {
	        LocalDate now = LocalDate.now();
	        String year = String.valueOf(now.getYear());
	        String month = String.format("%02d", now.getMonthValue());
	
	        // Fetch the next series number for the current month and year
	        int nextSeries = getNextSeriesForCurrentYearAndMonth(year, month);
	
	        // Format the series as a 3-digit number with leading zeros
	        String series = String.format("%03d", nextSeries);
	
	        return "PH-" + year + "-" + month + "-" + series;
	    }
	
	    private int getNextSeriesForCurrentYearAndMonth(String year, String month) {
	        // Define the control number prefix with both the year and month
	        String prefix = "PH-" + year + "-" + month + "-";
	        
	        // Find requests with control numbers starting with this prefix
	        List<Request> requestsForMonth = requestRepository.findByControlNumberStartingWith(prefix);
	        
	        // Extract and find the maximum series number for this year and month, then increment it by 1
	        return requestsForMonth.stream()
	            .map(request -> request.getControlNumber().substring(prefix.length())) // Extract the series part
	            .mapToInt(Integer::parseInt) // Convert to integer
	            .max() // Get the max value
	            .orElse(0) + 1; // Start at 1 if none exist
	    }

		public List<RequestDTO> getPendingRequestsDTO() {
			List<Request> pendingRequests = requestRepository.findByRequestStatus(Request.RequestStatus.PENDING_REVIEW);
			return pendingRequests.stream()
					.map(request -> new RequestDTO(
							request.getRequestId(),
							request.getRepresentativeName(),
							request.getContactNumber(),
							request.getEmailAddress(),
							request.getCompanyName(),
							request.getRequestStatus(),
							request.getSubmissionDate()
					))
					.collect(Collectors.toList());
		}
	}