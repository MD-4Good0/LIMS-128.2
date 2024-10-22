package com.backend.lims.model;


import com.backend.lims.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff {
	@Id
    @Column(name = "user_id")
    private Long userId;

	@Column(name = "staff_number", length = 255)
	private String staffNumber;
	
	@OneToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	public Staff() {
		
	}
	
	public Staff(Long userId, User user, String staffNumber) {
		super();
		this.userId = userId;
		this.user = user;
		this.staffNumber = staffNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
