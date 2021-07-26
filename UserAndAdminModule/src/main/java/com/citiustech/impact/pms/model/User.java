package com.citiustech.impact.pms.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

  

	@Column(name = "email_id",unique = true)
    private String emailID;


    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "password")
    private String password;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
    private PatientProfile userProfile;
    
    @Column(name = "role_master_id")
    private int roleID;

    public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public User() {

    }

	public User(String emailID, long phoneNumber, String password,int roleID) {
		
		this.emailID = emailID;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.roleID=roleID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PatientProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(PatientProfile userProfile) {
		this.userProfile = userProfile;
	}
    

    @Override
	public String toString() {
		return "User [id=" + id + ", emailID=" + emailID + ", phoneNumber=" + phoneNumber + ", password=" + password
				+ ", userProfile=" + userProfile + ", roleID=" + roleID + "]";
	}

   
}