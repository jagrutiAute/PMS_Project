package com.citiustech.impact.pms.service;

import com.citiustech.impact.pms.DTO.PatientDTO;

public interface PatientService {
	
	public String login(String email, String password);

	public String savePatient(PatientDTO p);


	
}
