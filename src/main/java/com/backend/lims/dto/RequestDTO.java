package com.backend.lims.dto;

import com.backend.lims.model.Request;

import java.time.LocalDate;

public class RequestDTO {
    private Long requestId;
    private String representativeName;
    private String contactNumber;
    private String emailAddress;
    private String companyName;
    private Request.RequestStatus requestStatus;
    private LocalDate submissionDate;

    public RequestDTO() {
    }

    public RequestDTO(Long requestId, String representativeName, String contactNumber, String emailAddress, String companyName, Request.RequestStatus requestStatus, LocalDate submissionDate) {
        this.requestId = requestId;
        this.representativeName = representativeName;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
        this.companyName = companyName;
        this.requestStatus = requestStatus;
        this.submissionDate = submissionDate;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
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

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Request.RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(Request.RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }
}
