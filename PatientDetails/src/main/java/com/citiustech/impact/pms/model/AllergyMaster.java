package com.citiustech.impact.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AllergyMaster {
	
	@Id
	@Column(name="id")
	private int id;
	

	@Column(name="name")
	private String allergyName;

	@Column(name="type")
	private String allergyType;

	@Column(name="")
	private String allergyDiscription;
	
	private String allergyClinicalInfo;
	
	private boolean isAllergyFatal;
	

	
}
