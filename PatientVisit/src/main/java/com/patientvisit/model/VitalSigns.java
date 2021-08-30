package com.patientvisit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vital_signs")
public class VitalSigns {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double height ;
	private Double weight;
	private Double bloodPressure;
	private Double bodyTemperature;
	private Double respirationRate;
	
	private String patientID;
	
	//@OneToOne
	//private PatientProfile patient;
	//@OneToOne
	//private Users user;
	
	public VitalSigns() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	
	
}
