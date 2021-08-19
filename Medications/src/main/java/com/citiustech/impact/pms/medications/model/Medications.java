package com.citiustech.impact.pms.medications.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

//@Entity
@Component
public class Medications {

	//@Id
	private Integer appNo;
	private Long productNo;
	private String from;
	private String strength;
	private String referenceDrug;
	private String drugName;
	private String activeIngedient;
	private String referenceStandard;
	public Medications() {
		super();
	}
	public Medications(Integer appNo, Long productNo, String from, String strength, String referenceDrug,
			String drugName, String activeIngedient, String referenceStandard) {
		super();
		this.appNo = appNo;
		this.productNo = productNo;
		this.from = from;
		this.strength = strength;
		this.referenceDrug = referenceDrug;
		this.drugName = drugName;
		this.activeIngedient = activeIngedient;
		this.referenceStandard = referenceStandard;
	}
	public Integer getAppNo() {
		return appNo;
	}
	public void setAppNo(Integer appNo) {
		this.appNo = appNo;
	}
	public Long getProductNo() {
		return productNo;
	}
	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public String getReferenceDrug() {
		return referenceDrug;
	}
	public void setReferenceDrug(String referenceDrug) {
		this.referenceDrug = referenceDrug;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getActiveIngedient() {
		return activeIngedient;
	}
	public void setActiveIngedient(String activeIngedient) {
		this.activeIngedient = activeIngedient;
	}
	public String getReferenceStandard() {
		return referenceStandard;
	}
	public void setReferenceStandard(String referenceStandard) {
		this.referenceStandard = referenceStandard;
	}
	@Override
	public String toString() {
		return "Medications [appNo=" + appNo + ", productNo=" + productNo + ", from=" + from + ", strength=" + strength
				+ ", referenceDrug=" + referenceDrug + ", drugName=" + drugName + ", activeIngedient=" + activeIngedient
				+ ", referenceStandard=" + referenceStandard + "]";
	}
	
	
}
