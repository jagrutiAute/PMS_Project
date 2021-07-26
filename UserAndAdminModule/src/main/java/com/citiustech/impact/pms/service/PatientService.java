package com.citiustech.impact.pms.service;

import com.citiustech.impact.pms.model.Patient;

public interface PatientService {
	
	public String login(String email, String password);

	public String addPatient(Patient p);


	
}
