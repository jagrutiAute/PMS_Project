package com.citiustech.impact.pms.DTO;

import lombok.Data;

@Data
public class MedicationDTO {

	
    private String applNo;
	
	//@Column(name="product_no")
	private String productNo;
	
	//@Column(name="form")
	private String form;
	
	//@Column(name="strength")
	private String strength;
	
	//@Column(name="reference_drug")
	private int referenceDrug;
	
	//@Column(name="drug_name")
	private String drugName;
	
	//@Column(name="active_ingredient")
	private String activeIngredient;
	
	//@Column(name="reference_standard")
	private int referenceStandard;
}
