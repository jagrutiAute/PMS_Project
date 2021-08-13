package com.citiustech.impact.pms.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "email_id")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "phone_number")
	private long phoneNumber;

	@Column(name = "login_attempts")
	private int loginAttempts;

	@Column(name = "enrolled")
	private Enrolled enrolled;

	@Column(name = "created_by", nullable = false, updatable = false)
	@CreatedBy
	private String createdBy;

	@Column(name = "created_date_time", nullable = false, updatable = false)
	@CreatedDate
//	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createDateAndTime;
//	private LocalDateTime createDateAndTime;

	@Column(name = "modified_by", nullable = false)
	@LastModifiedBy
	private String modifiedBy;

	@Column(name = "modified_date_time", nullable = false)
	@LastModifiedDate
//	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime modifiedDateAndTime;

	@Column(name = "is_active_role")
	private ISActive isActive;

	@Column(name = "password_changed_status")
	private int passowrdChangedStatus;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_master_id")
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

	public LocalDateTime getCreateDateAndTime() {
		return createDateAndTime;
	}

	public void setCreateDateAndTime(LocalDateTime createDateAndTime) {
		this.createDateAndTime = createDateAndTime;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedDateAndTime() {
		return modifiedDateAndTime;
	}

	public void setModifiedDateAndTime(LocalDateTime modifiedDateAndTime) {
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
