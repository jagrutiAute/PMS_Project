package com.citiustech.impact.pms.model;

import java.util.Calendar;

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

<<<<<<< HEAD
	//@JoinColumn(name = "users_id")
||||||| a39b143
	@JoinColumn(name = "users_id")
=======
	
>>>>>>> 44a197e0587bd6ddf153911f18dfba247cf3c7bc

<<<<<<< HEAD
	/*@OneToOne(cascade = CascadeType.ALL)
||||||| a39b143
	@OneToOne(cascade = CascadeType.ALL)
=======
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "users_id")
>>>>>>> 44a197e0587bd6ddf153911f18dfba247cf3c7bc
	private Users user;

	
<<<<<<< HEAD
	private String race;
	private String ethinicity;
*/
	/*
	 * @JoinColumn(name = "race_id")
	 * 
	 * @OneToOne(cascade = CascadeType.ALL) private Race race;
	 * 
	 * @JoinColumn(name = "ethinicity_id")
	 * 
	 * @OneToOne(cascade = CascadeType.ALL) private Ethinicity ethinicity;
	 */
||||||| a39b143
	private String race;
	private String ethinicity;

	/*
	 * @JoinColumn(name = "race_id")
	 * 
	 * @OneToOne(cascade = CascadeType.ALL) private Race race;
	 * 
	 * @JoinColumn(name = "ethinicity_id")
	 * 
	 * @OneToOne(cascade = CascadeType.ALL) private Ethinicity ethinicity;
	 */
=======

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "race_master_id")
	private Race race;

>>>>>>> 44a197e0587bd6ddf153911f18dfba247cf3c7bc
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ethnicity_master_id")
	private Ethinicity ethinicity;

}
