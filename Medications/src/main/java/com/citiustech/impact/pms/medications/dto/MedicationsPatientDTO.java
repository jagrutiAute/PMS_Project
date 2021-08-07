package com.citiustech.impact.pms.medications.dto;

import java.util.List;

import com.citiustech.impact.pms.medications.model.Medications;
import com.citiustech.impact.pms.medications.model.PatientMedications;

public class MedicationsPatientDTO {

	private List<Medications> medications;
	private String pid;
	private String phid;
	
	/*
	 * {
	 * 		
	 * }
	 * 
	 */
	public MedicationsPatientDTO() {
		super();
	}
	public MedicationsPatientDTO(List<Medications> medications, String pid, String phid) {
		super();
		this.medications = medications;
		this.pid = pid;
		this.phid = phid;
	}
	public List<Medications> getMedications() {
		return medications;
	}
	public void setMedications(List<Medications> medications) {
		this.medications = medications;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPhid() {
		return phid;
	}
	public void setPhid(String phid) {
		this.phid = phid;
	}
	@Override
	public String toString() {
		return "MedicationsPatientDTO [medications=" + medications + ", pid=" + pid + ", phid=" + phid + "]";
	}
	
	
	
}
