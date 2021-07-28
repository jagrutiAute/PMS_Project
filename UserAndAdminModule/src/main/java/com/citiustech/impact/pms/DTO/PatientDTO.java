package com.citiustech.impact.pms.DTO;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class PatientDTO {
	
	String title;
	String fname;
	String lname;
	String email;
	Calendar dob;
	long contact;
	String pwd;
	
	public PatientDTO() {
		super();
	}
	public PatientDTO(String title, String fname, String lname, String email, Calendar dob, long contact,
			String pwd) {
		super();
		this.title = title;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.dob = dob;
		this.contact = contact;
		this.pwd = pwd;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getDob() {
		return dob;
	}
	public void setDob(Calendar dob) {
		this.dob = dob;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Patient [title=" + title + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", dob=" + dob
				+ ", contact=" + contact + ", pwd=" + pwd + "]";
	}

}
