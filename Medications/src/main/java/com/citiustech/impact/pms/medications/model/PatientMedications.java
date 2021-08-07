package com.citiustech.impact.pms.medications.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "patient_medications")
public class PatientMedications {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/*
	 * @ManyToOne private Medications medications;
	 */
	
	@OneToOne
	@JoinColumn(name = "pID",referencedColumnName = "email_id")
	private Users patientID;

	@OneToOne
	@JoinColumn(name = "phID" ,referencedColumnName = "email_id")
	private Users physicanID;

	public PatientMedications() {
		super();
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Users getPatientID() {
		return patientID;
	}

	public void setPatientID(Users patientID) {
		this.patientID = patientID;
	}

	public Users getPhysicanID() {
		return physicanID;
	}

	public void setPhysicanID(Users physicanID) {
		this.physicanID = physicanID;
	}

	@Override
	public String toString() {
		return "PatientMedications [id=" + id + ", medications="  + ", patientID=" + patientID
				+ ", physicanID=" + physicanID + "]";
	}

	
}
