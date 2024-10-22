package com.backend.lims.model;

import java.sql.Date;

import com.backend.lims.model.UnverifiedUser;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
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

	public User() {
		
	}
	
	public User(UnverifiedUser unvUser) {
		this.userId = unvUser.getUserId();
		this.username = unvUser.getUsername();
		this.firstName = unvUser.getFirstName();
		this.middleName = unvUser.getMiddleName();
		this.lastName =  unvUser.getLastName();
		this.contactNumber =  unvUser.getContactNumber();
		this.email =  unvUser.getEmail();
		this.password =  unvUser.getPassword();
		this.userType =  unvUser.getUserType();
	}

	public User(Long userId, String username, String firstName, String middleName, String lastName, Integer age, String sex, Date birthday, String address, String contactNumber, String email, String password, String avatar, String userType, String deletionStatus) {
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
	}

	public User(Long userId, String username, String firstName, String middleName, String lastName, int age, String sex,
				Date birthday, String address, String contactNumber, String email, String password, String userType, String avatar) {
		super();
		this.userId = userId;
		this.username = username;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
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
	
	

}
