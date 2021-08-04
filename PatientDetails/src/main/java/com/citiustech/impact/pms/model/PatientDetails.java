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

@Table(name = "patient")

public class PatientDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "users_id")
	private Users user;

	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "race_master_id")
	private Race race;

	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ethnicity_master_id")
	private Ethinicity ethinicity;

}
