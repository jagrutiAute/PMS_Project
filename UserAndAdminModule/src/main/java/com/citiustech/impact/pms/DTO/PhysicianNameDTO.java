package com.citiustech.impact.pms.DTO;

import javax.persistence.Column;

public class PhysicianNameDTO {
    
	private String first_name;
	
	private String last_name;

	public PhysicianNameDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhysicianNameDTO(String first_name, String last_name) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return "PhysicianNameDTO [first_name=" + first_name + ", last_name=" + last_name + "]";
	}
	
	
	
}
