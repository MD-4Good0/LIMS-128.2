package com.backend.lims.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Transactional
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;
    
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

	@OneToMany(targetEntity = Sample.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fkRequestId", referencedColumnName = "requestId")
	private List<Sample> sample;

    // Purpose of Testing (ENUM for better management)
    @Enumerated(EnumType.STRING)
    private TestingPurpose testingPurpose;

	private Boolean isMicrobial;

	private Boolean isChem;

	private Boolean isMolBio;

    // Test Selection (Can be a list of selected tests) ~> should be enumerated in frontend
    @ElementCollection
    private List<String> testSelectionMicrobial;

	@ElementCollection
	private List<String> testSelectionChem;

	@ElementCollection
	private List<String> testSelectionMolBio;

    // Request Status
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    // Control Number
	// What is this control number
    private String controlNumber;

    // Submission Date
    private LocalDate submissionDate;

    // Timestamps
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

	public Request() {
	}

	public Request(Long requestId, Client client, String representativeName, String contactNumber, String emailAddress, String companyName, String clientClassification, String ltoNumber, List<Sample> sample, TestingPurpose testingPurpose, Boolean isMicrobial, Boolean isChem, Boolean isMolBio, List<String> testSelectionMicrobial, List<String> testSelectionChem, List<String> testSelectionMolBio, RequestStatus requestStatus, String controlNumber, LocalDate submissionDate, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.requestId = requestId;
		this.client = client;
		this.representativeName = representativeName;
		this.contactNumber = contactNumber;
		this.emailAddress = emailAddress;
		this.companyName = companyName;
		this.clientClassification = clientClassification;
		this.ltoNumber = ltoNumber;
		this.sample = sample;
		this.testingPurpose = testingPurpose;
		this.isMicrobial = isMicrobial;
		this.isChem = isChem;
		this.isMolBio = isMolBio;
		this.testSelectionMicrobial = testSelectionMicrobial;
		this.testSelectionChem = testSelectionChem;
		this.testSelectionMolBio = testSelectionMolBio;
		this.requestStatus = requestStatus;
		this.controlNumber = controlNumber;
		this.submissionDate = submissionDate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
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

	public List<Sample> getSample() {
		return sample;
	}

	public void setSample(List<Sample> sample) {
		this.sample = sample;
	}

	public TestingPurpose getTestingPurpose() {
		return testingPurpose;
	}

	public void setTestingPurpose(TestingPurpose testingPurpose) {
		this.testingPurpose = testingPurpose;
	}

	public Boolean getMicrobial() {
		return isMicrobial;
	}

	public void setMicrobial(Boolean microbial) {
		isMicrobial = microbial;
	}

	public Boolean getChem() {
		return isChem;
	}

	public void setChem(Boolean chem) {
		isChem = chem;
	}

	public Boolean getMolBio() {
		return isMolBio;
	}

	public void setMolBio(Boolean molBio) {
		isMolBio = molBio;
	}

	public List<String> getTestSelectionMicrobial() {
		return testSelectionMicrobial;
	}

	public void setTestSelectionMicrobial(List<String> testSelectionMicrobial) {
		this.testSelectionMicrobial = testSelectionMicrobial;
	}

	public List<String> getTestSelectionChem() {
		return testSelectionChem;
	}

	public void setTestSelectionChem(List<String> testSelectionChem) {
		this.testSelectionChem = testSelectionChem;
	}

	public List<String> getTestSelectionMolBio() {
		return testSelectionMolBio;
	}

	public void setTestSelectionMolBio(List<String> testSelectionMolBio) {
		this.testSelectionMolBio = testSelectionMolBio;
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
