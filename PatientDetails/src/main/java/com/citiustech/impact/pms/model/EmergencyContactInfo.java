package com.citiustech.impact.pms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "emergency_contact_info")
public class EmergencyContactInfo {

	@Id
    
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "address")
	private String homeAddress;

	@Column(name = "email")
	private String emergencyEmail;

	@Column(name = "contact_number")
	private String emergencyContact;

	@Column(name = "patient_portal_access")
	private String patientPortalAccess;
	
	

	@JoinColumn(name = "mrnNumber")

	@OneToOne(cascade = CascadeType.ALL)
	private PatientDetails patientDetails;

}
