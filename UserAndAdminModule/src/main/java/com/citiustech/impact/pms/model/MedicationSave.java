package com.citiustech.impact.pms.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="medicationsave")
public class MedicationSave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="appl_no")
	private String applNo;
	
	@Column(name="product_no")
	private String productNo;
	
	@Column(name="form")
	private String form;
	
	@Column(name="strength")
	private String strength;
	
	@Column(name="reference_drug")
	private String referenceDrug;
	
	@Column(name="drug_name")
	private String drugName;
	
	@Column(name="active_ingredient")
	private String activeIngredient;
	
	@Column(name="reference_standard")
	private String referenceStandard;
	
	
	private String pid;
	
		
	private LocalDate date;
	
}
