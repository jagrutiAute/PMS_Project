package com.citiustech.impact.pms.medications.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "email_id")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "phone_number")
	private Long phoneNumber;

	@Column(name = "login_attempts")
	private Integer loginAttempts;

	@Column(name = "enrolled")
	private Enrolled enrolled;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date_time")
	private LocalDate createDateAndTime;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "modified_date_time")
	private LocalDate modifiedDateAndTime;

	@Column(name = "is_active_role")
	private ISActive isActive;

	@Column(name = "password_changed_status")
	private Integer passowrdChangedStatus;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_master_id")
	private Role role;

	public Users() {
		super();
	}

	public Users(Integer id, String email, String password, Long phoneNumber, Integer loginAttempts, Enrolled enrolled,
			String createdBy, LocalDate createDateAndTime, String modifiedBy, LocalDate modifiedDateAndTime,
			ISActive isActive, Integer passowrdChangedStatus, Role role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.loginAttempts = loginAttempts;
		this.enrolled = enrolled;
		this.createdBy = createdBy;
		this.createDateAndTime = createDateAndTime;
		this.modifiedBy = modifiedBy;
		this.modifiedDateAndTime = modifiedDateAndTime;
		this.isActive = isActive;
		this.passowrdChangedStatus = passowrdChangedStatus;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(Integer loginAttempts) {
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

	public Integer getPassowrdChangedStatus() {
		return passowrdChangedStatus;
	}

	public void setPassowrdChangedStatus(Integer passowrdChangedStatus) {
		this.passowrdChangedStatus = passowrdChangedStatus;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", password=" + password + ", phoneNumber=" + phoneNumber
				+ ", loginAttempts=" + loginAttempts + ", enrolled=" + enrolled + ", createdBy=" + createdBy
				+ ", createDateAndTime=" + createDateAndTime + ", modifiedBy=" + modifiedBy + ", modifiedDateAndTime="
				+ modifiedDateAndTime + ", isActive=" + isActive + ", passowrdChangedStatus=" + passowrdChangedStatus
				+ ", role=" + role + "]";
	}

	
}
