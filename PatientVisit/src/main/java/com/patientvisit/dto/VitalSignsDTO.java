package com.patientvisit.dto;

public class VitalSignsDTO {

	
	private Double height ;
	private Double weight;
	private Double bloodPressure;
	private Double bodyTemperature;
	private Double respirationRate;
	
	private String mrnNumebr;
	
	
	public VitalSignsDTO() {
		super();
	}


	public VitalSignsDTO(Double height, Double weight, Double bloodPressure, Double bodyTemperature,
			Double respirationRate, String mrnNumebr) {
		super();
		this.height = height;
		this.weight = weight;
		this.bloodPressure = bloodPressure;
		this.bodyTemperature = bodyTemperature;
		this.respirationRate = respirationRate;
		
		this.mrnNumebr = mrnNumebr;
	}


	public Double getHeight() {
		return height;
	}


	public void setHeight(Double height) {
		this.height = height;
	}


	public Double getWeight() {
		return weight;
	}


	public void setWeight(Double weight) {
		this.weight = weight;
	}


	public Double getBloodPressure() {
		return bloodPressure;
	}


	public void setBloodPressure(Double bloodPressure) {
		this.bloodPressure = bloodPressure;
	}


	public Double getBodyTemperature() {
		return bodyTemperature;
	}


	public void setBodyTemperature(Double bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}


	public Double getRespirationRate() {
		return respirationRate;
	}


	public void setRespirationRate(Double respirationRate) {
		this.respirationRate = respirationRate;
	}



	public String getMrnNumebr() {
		return mrnNumebr;
	}


	public void setMrnNumebr(String mrnNumebr) {
		this.mrnNumebr = mrnNumebr;
	}


	@Override
	public String toString() {
		return "VitalSignsDTO [height=" + height + ", weight=" + weight + ", bloodPressure=" + bloodPressure
				+ ", bodyTemperature=" + bodyTemperature + ", respirationRate=" + respirationRate + 
				", mrnNumebr=" + mrnNumebr + "]";
	}


	
}
