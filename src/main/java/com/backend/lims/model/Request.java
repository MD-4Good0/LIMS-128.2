package com.backend.lims.model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    public enum TestingPurpose {
        Monitoring, Local_Trade, Imported, Export, Complaint, Others
    }

    public enum RequestStatus {
        PENDING_REVIEW, FOR_TESTING, FOR_RELEASE, REJECTED
    }

    // Client Information
    @ManyToOne
    private Client client;  // Prefilled client information based on logged-in user
    private String representativeName;
    private String contactNumber;
    private String emailAddress;
    private String companyName;
    private String clientClassification;
    private String ltoNumber;

    // Sample Information
    private String sampleTypeDescription;
    private String lotBatchNo;
    private String sampleSource;
    private LocalDate productionDate;
    private LocalDate expiryDate;
    private LocalDate samplingDate;
    private String samplerName;

    // Purpose of Testing (ENUM for better management)
    @Enumerated(EnumType.STRING)
    private TestingPurpose testingPurpose;

    // Test Selection (Can be a list of selected tests)
    @ElementCollection
    private List<String> testSelections;

    // Request Status
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    // Control Number
    private String controlNumber;

    // Submission Date
    private LocalDate submissionDate;

    // Timestamps
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

	public Request() {
	}

	public Request(Long id, Client client, String representativeName, String contactNumber, String emailAddress, String companyName, String clientClassification, String ltoNumber, String sampleTypeDescription, String lotBatchNo, String sampleSource, LocalDate productionDate, LocalDate expiryDate, LocalDate samplingDate, String samplerName, TestingPurpose testingPurpose, List<String> testSelections, RequestStatus requestStatus, String controlNumber, LocalDate submissionDate, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.client = client;
		this.representativeName = representativeName;
		this.contactNumber = contactNumber;
		this.emailAddress = emailAddress;
		this.companyName = companyName;
		this.clientClassification = clientClassification;
		this.ltoNumber = ltoNumber;
		this.sampleTypeDescription = sampleTypeDescription;
		this.lotBatchNo = lotBatchNo;
		this.sampleSource = sampleSource;
		this.productionDate = productionDate;
		this.expiryDate = expiryDate;
		this.samplingDate = samplingDate;
		this.samplerName = samplerName;
		this.testingPurpose = testingPurpose;
		this.testSelections = testSelections;
		this.requestStatus = requestStatus;
		this.controlNumber = controlNumber;
		this.submissionDate = submissionDate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getRepresentativeName() {
		return representativeName;
	}
	public void setRepresentativeName(String representativeName) {
		this.representativeName = representativeName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getClientClassification() {
		return clientClassification;
	}
	public void setClientClassification(String clientClassification) {
		this.clientClassification = clientClassification;
	}
	public String getLtoNumber() {
		return ltoNumber;
	}
	public void setLtoNumber(String ltoNumber) {
		this.ltoNumber = ltoNumber;
	}
	public String getSampleTypeDescription() {
		return sampleTypeDescription;
	}
	public void setSampleTypeDescription(String sampleTypeDescription) {
		this.sampleTypeDescription = sampleTypeDescription;
	}
	public String getLotBatchNo() {
		return lotBatchNo;
	}
	public void setLotBatchNo(String lotBatchNo) {
		this.lotBatchNo = lotBatchNo;
	}
	public String getSampleSource() {
		return sampleSource;
	}
	public void setSampleSource(String sampleSource) {
		this.sampleSource = sampleSource;
	}
	public LocalDate getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(LocalDate productionDate) {
		this.productionDate = productionDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public LocalDate getSamplingDate() {
		return samplingDate;
	}
	public void setSamplingDate(LocalDate samplingDate) {
		this.samplingDate = samplingDate;
	}
	public String getSamplerName() {
		return samplerName;
	}
	public void setSamplerName(String samplerName) {
		this.samplerName = samplerName;
	}
	public TestingPurpose getTestingPurpose() {
		return testingPurpose;
	}
	public void setTestingPurpose(TestingPurpose testingPurpose) {
		this.testingPurpose = testingPurpose;
	}
	public List<String> getTestSelections() {
		return testSelections;
	}
	public void setTestSelections(List<String> testSelections) {
		this.testSelections = testSelections;
	}
	public RequestStatus getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getControlNumber() {
		return controlNumber;
	}
	public void setControlNumber(String controlNumber) {
		this.controlNumber = controlNumber;
	}
	public LocalDate getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(LocalDate submissionDate) {
		this.submissionDate = submissionDate;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
