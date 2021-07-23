package com.citiustech.impact.pms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient_allergy_details")

public class PatientAllergyDetails {

	@Id
	@Column(name = "mrn")
	private int mrnNumber;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "language_known")
	private String languageKnown;
	
	@Column(name = "home_address")
	private String homeAddress;
	
	
	@JoinColumn(name = "users_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Users user;
	
}
