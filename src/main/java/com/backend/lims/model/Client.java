package com.backend.lims.model;

import com.backend.lims.model.User;
import com.backend.lims.model.UnverifiedClient;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
	@Id
    @Column(name = "user_id")
    private Long userId;

 	@Column(name = "company_name", length = 255)
    private String companyName;
 	
 	@Column(name = "classification", length = 255)
    private String classification;

    @Column(name = "lto_no", length = 15)
    private String ltoNo;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    public Client() {
    	
    }
    
    public Client(UnverifiedClient unvClient) {
		this.userId = unvClient.getUserId();
		this.companyName =  unvClient.getCompanyName();
		this.ltoNo =  unvClient.getLtoNo();
		this.classification = unvClient.getClassification();
	}

	public Client(Long userId, String companyName, String classification, String ltoNo, User user) {
		super();
		this.userId = userId;
		this.companyName = companyName;
		this.classification = classification;
		this.ltoNo = ltoNo;
		this.user = user;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLtoNo() {
		return ltoNo;
	}

	public void setLtoNo(String ltoNo) {
		this.ltoNo = ltoNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}


}
