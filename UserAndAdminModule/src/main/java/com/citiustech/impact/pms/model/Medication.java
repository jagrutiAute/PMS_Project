package com.citiustech.impact.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="productmedication")
public class Medication {

	
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private Integer id;
	@Id
	@Column(name="applno")
	private String applNo;
	
	@Column(name="productno")
	private String productNo;
	
	@Column(name="form")
	private String form;
	
	@Column(name="strength")
	private String strength;
	
	@Column(name="referencedrug")
	private int referenceDrug;
	
	@Column(name="drugname")
	private String drugName;
	
	@Column(name="activeingredient")
	private String activeIngredient;
	
	@Column(name="referencestandard")
	private int referenceStandard;
	
}
