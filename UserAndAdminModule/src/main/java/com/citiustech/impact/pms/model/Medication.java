package com.citiustech.impact.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="productmedication1")
public class Medication {

	@Id
	@Column(name="appl_no")
	private String applNo;
	
	@Column(name="product_no")
	private String productNo;
	
	@Column(name="form")
	private String form;
	
	@Column(name="strength")
	private String strength;
	
	@Column(name="reference_drug")
	private int referenceDrug;
	
	@Column(name="drug_name")
	private String drugName;
	
	@Column(name="active_ingredient")
	private String activeIngredient;
	
	@Column(name="reference_standard")
	private int referenceStandard;
	
}
