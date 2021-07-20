package com.citiustech.impact.pms.model;


public class ProviderRegistrationDTO {

	
	private String title;
	private String firstName;
	private String lastName;
	private String username;
	private String date_of_birth;
	private int role;
	private String employeeid;
	
	
	public ProviderRegistrationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProviderRegistrationDTO(String title, String firstName, String lastName, String username,
			String date_of_birth, int role, String employeeid) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.date_of_birth = date_of_birth;
		this.role = role;
		this.employeeid = employeeid;
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	public String getEmployeeid() {
		return employeeid;
	}


	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}


	@Override
	public String toString() {
		return "ProviderRegistrationDTO [title=" + title + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", date_of_birth=" + date_of_birth + ", role=" + role + ", employeeid="
				+ employeeid + "]";
	}


	
	
	
	
}
