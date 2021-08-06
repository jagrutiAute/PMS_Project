package com.citiustech.impact.pms.allergies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "allergy_details")
@Data
@NoArgsConstructor
public class Allergy {

	@Id
	@Column(name = "id")
	
	private Integer id;
	private String type;
	private String name;
	private String source;
	private String isoForms;
	private String allerginiCity;
}
