package com.patientvisit.dto;

public class VitalSignsDTO {

	
	private Double height ;
	private Double weight;
	private Double bloodPressure;
	private Double bodyTemperature;
	private Double respirationRate;
	private String userID;
	private String patientID;
	
	
	public VitalSignsDTO() {
		super();
	}


	public VitalSignsDTO(Double height, Double weight, Double bloodPressure, Double bodyTemperature,
			Double respirationRate, String userID, String patientID) {
		super();
		this.height = height;
		this.weight = weight;
		this.bloodPressure = bloodPressure;
		this.bodyTemperature = bodyTemperature;
		this.respirationRate = respirationRate;
		this.userID = userID;
		this.patientID = patientID;
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


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getPatientID() {
		return patientID;
	}


	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}


	@Override
	public String toString() {
		return "VitalSignsDTO [height=" + height + ", weight=" + weight + ", bloodPressure=" + bloodPressure
				+ ", bodyTemperature=" + bodyTemperature + ", respirationRate=" + respirationRate + ", userID=" + userID
				+ ", patientID=" + patientID + "]";
	}


	
}
