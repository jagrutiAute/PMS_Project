package com.patientvisit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	@OneToOne
	private Users user;
	@OneToOne
	private Users patient;
	public VitalSigns() {
		super();
	}
	public VitalSigns(Integer id, Double height, Double weight, Double bloodPressure, Double bodyTemperature,
			Double respirationRate, Users user, Users patient) {
		super();
		this.id = id;
		this.height = height;
		this.weight = weight;
		this.bloodPressure = bloodPressure;
		this.bodyTemperature = bodyTemperature;
		this.respirationRate = respirationRate;
		this.user = user;
		this.patient = patient;
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
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Users getPatient() {
		return patient;
	}
	public void setPatient(Users patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "VitalSigns [id=" + id + ", height=" + height + ", weight=" + weight + ", bloodPressure=" + bloodPressure
				+ ", bodyTemperature=" + bodyTemperature + ", respirationRate=" + respirationRate + ", user=" + user
				+ ", patient=" + patient + "]";
	}
	
}
