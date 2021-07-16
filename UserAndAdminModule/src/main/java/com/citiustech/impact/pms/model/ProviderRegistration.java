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


@Data
@Entity
@Table(name="provider")
public class ProviderRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="date_of_birth")
	private String date_of_birth;
	
		
	@Column(name="employee_id")
	private String employeeid;
	
	
	@JoinColumn(name = "users_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Users user;

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
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



	public String getDate_of_birth() {
		return date_of_birth;
	}



	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	
	public String getEmployeeid() {
		return employeeid;
	}


	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}



	public Users getUser() {
		return user;
	}



	public void setUser(Users user) {
		this.user = user;
	}



	public ProviderRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ProviderRegistration(int id, String title, String firstName, String lastName, String date_of_birth,
			String employeeid, Users user) {
		super();
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date_of_birth = date_of_birth;
		this.employeeid = employeeid;
		this.user = user;
	}



	@Override
	public String toString() {
		return "ProviderRegistration [id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName="
				+ lastName + ", date_of_birth=" + date_of_birth + ", employeeID=" + employeeid + ", user=" + user + "]";
	}
	
	
}
