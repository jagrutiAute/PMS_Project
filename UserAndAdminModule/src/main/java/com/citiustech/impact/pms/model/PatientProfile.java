package com.citiustech.impact.pms.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "patient")
public class PatientProfile implements Serializable {
    @Id
    @Column(name = "mrn")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @Enumerated(EnumType.STRING)
    //@Column(length = 10)
    private String title;
    
   

	@Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Calendar dateOfBirth;

   

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", nullable = false)
<<<<<<< HEAD
    private Users user;
=======
    private User user;
>>>>>>> b707ea0bb99d2dafbba5d70514928c2fbc430850
    
    @Column(name = "ethnicity_master_id")
    private int ethnicity;
    
    @Column(name = "race_master_id")
    private int race;

  

	public PatientProfile() {
		super();
	}

	public PatientProfile( String title, String firstName, String lastName, Calendar dateOfBirth,
			int ethnicity, int race) {
		
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.ethnicity = ethnicity;
		this.race = race;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

<<<<<<< HEAD
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
=======
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
>>>>>>> b707ea0bb99d2dafbba5d70514928c2fbc430850
		this.user = user;
	}

	public int getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(int ethnicity) {
		this.ethnicity = ethnicity;
	}

	public int getRace() {
		return race;
	}

	public void setRace(int race) {
		this.race = race;
	}

	@Override
	public String toString() {
		return "PatientProfile [id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", user=" + user + ", ethnicity=" + ethnicity + ", race=" + race
				+ "]";
	}


	
    
    

}