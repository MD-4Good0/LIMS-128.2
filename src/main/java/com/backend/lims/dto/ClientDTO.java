package com.backend.lims.dto;


import com.backend.lims.model.Client;
import org.springframework.web.bind.annotation.GetMapping;

public class ClientDTO {
    private Long id;
    private String username;
    private String contactNumber;
    private String email;
    private String companyName;
    private String ltoNumber;
    private String classification;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String username, String contactNumber, String email, String companyName, String ltoNumber, String classification) {
        this.id = id;
        this.username = username;
        this.contactNumber = contactNumber;
        this.email = email;
        this.companyName = companyName;
        this.ltoNumber = ltoNumber;
        this.classification = classification;
    }

    public ClientDTO(Client client){
        super();
        this.id = client.getUserId();
        this.username = client.getUser().getUsername();
        this.contactNumber = client.getUser().getContactNumber();
        this.email = client.getUser().getEmail();
        this.companyName = client.getCompanyName();
        this.ltoNumber = client.getLtoNo();
        this.classification = client.getClassification();
    }

    public ClientDTO(String username, String contactNumber, String email, String companyName, String ltoNo, String classification) {
        this.username = username;
        this.contactNumber = contactNumber;
        this.email = email;
        this.companyName = companyName;
        this.ltoNumber = ltoNo;
        this.classification = classification;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLtoNumber() {
        return ltoNumber;
    }

    public void setLtoNumber(String ltoNumber) {
        this.ltoNumber = ltoNumber;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
