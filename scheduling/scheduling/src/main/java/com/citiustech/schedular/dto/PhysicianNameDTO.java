package com.citiustech.schedular.dto;


public class PhysicianNameDTO {
    
	private String phyid;
	
	private String firstName;
	
	private String lastName;

	public PhysicianNameDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhysicianNameDTO(String phyid, String firstName, String lastName) {
		super();
		this.phyid = phyid;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getPhyid() {
		return phyid;
	}

	public void setPhyid(String phyid) {
		this.phyid = phyid;
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

	@Override
	public String toString() {
		return "PhysicianNameDTO [phyid=" + phyid + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	

	
	
	
	
}
