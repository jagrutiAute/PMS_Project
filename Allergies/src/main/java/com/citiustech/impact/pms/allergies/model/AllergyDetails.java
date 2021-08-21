package com.citiustech.impact.pms.allergies.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patient_allergy")
@Data
@NoArgsConstructor
public class AllergyDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String pid;
	private String allergyName;
	private String type;
	private String createdBy;
	private Calendar createdDateNTime;
	private String modifiedBy;
	private Calendar modifiedDateNtime;
	
	private String source;
	private String isoForms;
	private String allerginiCity;
	
	
	//@JoinColumn(name = "allergy_id")
	//@OneToOne(cascade = CascadeType.ALL)
	//private List<Allergy> allergy;
	
	//@JoinColumn(name = "id")
	//@OneToOne(cascade = CascadeType.ALL)
	//private Integer patientVisit;

}
