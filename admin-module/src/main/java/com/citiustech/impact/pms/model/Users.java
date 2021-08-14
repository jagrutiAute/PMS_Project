package com.citiustech.impact.pms.model;

import java.time.LocalDate;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class Users {

	
	private Long id;

	
	private String email;

	
	private String password;

	
	private long phoneNumber;

	
	private int loginAttempts;

	
	private Enrolled enrolled;

	
	private String createdBy;

	
	private LocalDate createDateAndTime;

	
	private String modifiedBy;

	
	private LocalDate modifiedDateAndTime;

	
	private ISActive isActive;

	
	private int passowrdChangedStatus;

	
	private Role role;

	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", password=" + password + ", phoneNumber=" + phoneNumber + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	public Enrolled getEnrolled() {
		return enrolled;
	}

	public void setEnrolled(Enrolled enrolled) {
		this.enrolled = enrolled;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreateDateAndTime() {
		return createDateAndTime;
	}

	public void setCreateDateAndTime(LocalDate createDateAndTime) {
		this.createDateAndTime = createDateAndTime;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDate getModifiedDateAndTime() {
		return modifiedDateAndTime;
	}

	public void setModifiedDateAndTime(LocalDate modifiedDateAndTime) {
		this.modifiedDateAndTime = modifiedDateAndTime;
	}

	public ISActive getIsActive() {
		return isActive;
	}

	public void setIsActive(ISActive isActive) {
		this.isActive = isActive;
	}

	public int getPassowrdChangedStatus() {
		return passowrdChangedStatus;
	}

	public void setPassowrdChangedStatus(int passowrdChangedStatus) {
		this.passowrdChangedStatus = passowrdChangedStatus;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
