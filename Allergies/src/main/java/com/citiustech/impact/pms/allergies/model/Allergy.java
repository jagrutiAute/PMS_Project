package com.citiustech.impact.pms.allergies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "allergy_master")
@Data
@NoArgsConstructor
public class Allergy {

	@Id
	@Column(name = "id")
	
	private String id;
	private String type;
	private String name;
	private String source;
	
	@Column(name="isoforms")
	private String isoForms;
	
	@Column(name="allerginicity")
	private String allerginiCity;
}
