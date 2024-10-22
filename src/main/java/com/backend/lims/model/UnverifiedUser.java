package com.backend.lims.model;

import java.sql.Date;

import com.backend.lims.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "unverified_users")
public class UnverifiedUser {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", nullable = false, unique = true, length = 20)
    private String username;

    @Column(name = "first_name", length = 30)
    private String firstName;

    @Column(name = "middle_name", length = 30)
    private String middleName;

    @Column(name = "last_name", length = 30)
    private String lastName;

    @Column(name = "contact_number", nullable = false, length = 12)
    private String contactNumber;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "pword", nullable = false)
    private String password;

    @Column(name = "user_type", nullable = false, length = 20)
    private String userType;

	@Column(name = "deletion_status", length = 50)
	private String deletionStatus;
	
	@Column(name = "otp")
	@JsonProperty("otp")
	Integer otp;
	
	
	public UnverifiedUser() {
	}
	
	public UnverifiedUser(User user, Integer otp) {
		this.userId = user.getUserId();
		this.username = user.getUsername();
		this.firstName = user.getFirstName();
		this.middleName = user.getMiddleName();
		this.lastName =  user.getLastName();
		this.contactNumber =  user.getContactNumber();
		this.email =  user.getEmail();
		this.password =  user.getPassword();
		this.userType =  user.getUserType();
		this.otp = otp;
	}

	public UnverifiedUser(Long userId, String username, String firstName, String middleName, String lastName, Date birthday, String address, String contactNumber, String email, String password, String userType, String deletionStatus, Integer otp) {
		this.userId = userId;
		this.username = username;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.deletionStatus = deletionStatus;
		this.otp = otp;
	}

	public UnverifiedUser(Long userId, String username, String firstName, String middleName, String lastName,
						  Date birthday, String address, String contactNumber, String email, String password,
						  Integer otp, String userType) {
		super();
		this.userId = userId;
		this.username = username;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.otp = otp;
		this.userType = userType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getDeletionStatus() {
		return deletionStatus;
	}

	public void setDeletionStatus(String deletionStatus) {
		this.deletionStatus = deletionStatus;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}
	
	

}
