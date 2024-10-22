package com.backend.lims.model;

import com.backend.lims.model.Client;
import com.backend.lims.model.UnverifiedUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "unverified_clients")
public class UnverifiedClient {
	
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
    private UnverifiedUser unvUser;
    
    public UnverifiedClient() {
	}
    
    public UnverifiedClient(Client client) {
		this.userId = client.getUserId();
		this.companyName =  client.getCompanyName();
		this.ltoNo =  client.getLtoNo();
		this.classification = client.getClassification();
	}

	public UnverifiedClient(Long userId, String companyName, String classification, String ltoNo, UnverifiedUser unvUser) {
		this.userId = userId;
		this.companyName = companyName;
		this.classification = classification;
		this.ltoNo = ltoNo;
		this.unvUser = unvUser;
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

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getLtoNo() {
		return ltoNo;
	}

	public void setLtoNo(String ltoNo) {
		this.ltoNo = ltoNo;
	}

	public UnverifiedUser getUnvUser() {
		return unvUser;
	}

	public void setUnvUser(UnverifiedUser unvUser) {
		this.unvUser = unvUser;
	}
	
	
}
