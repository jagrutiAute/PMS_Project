
package com.citiustech.impact.pms.model;


import java.util.Calendar;


public class PatientProfile {
	
	private Long id;

	// @Enumerated(EnumType.STRING)
	// @Column(length = 10)
	
	private String title;

	private String firstName;

	private String lastName;

	private Calendar dateOfBirth;

	private int age;
	
     private String gender;

	private Users user;

	private int ethnicity;

	private int race;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public PatientProfile() {
		super();
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PatientProfile [id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", user=" + user + "]";
	}

}
