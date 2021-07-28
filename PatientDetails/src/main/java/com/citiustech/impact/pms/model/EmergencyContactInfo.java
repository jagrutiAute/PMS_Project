package com.citiustech.impact.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "emergency_contact_info")
public class EmergencyContactInfo {
	
	@Id

	@Column(name="id")
	private int id;

	@Column(name="title")
	private String title;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="address")
	private String homeAddress;

	@Column(name="email")
	private String emergencyEmail;

	@Column(name="contact_number")
	private String emergencyContact;

	@Column(name="patient_portal_access")
	private boolean patientPortalAccess;
	
	
	
	
	

}
