package com.backend.lims.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "testers")
public class Tester {
	@Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "spec", nullable = false, length = 50)
    private String specialization;

	@Column(name = "license_number", length = 255)
	private String licenseNumber;
	
	@OneToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	public Tester() {
		
	}
	

	public Tester(Long userId, String specialization, User user, String licenseNumber) {
		super();
		this.userId = userId;
		this.specialization = specialization;
		this.user = user;
		this.licenseNumber = licenseNumber;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getSpecialization() {
		return specialization;
	}


	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	public String getLicenseNumber() {
		return licenseNumber;
	}


	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
