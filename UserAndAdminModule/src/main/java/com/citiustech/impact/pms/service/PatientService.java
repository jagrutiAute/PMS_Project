package com.citiustech.impact.pms.service;

import java.util.List;
import java.util.Optional;

import com.citiustech.impact.pms.DTO.PatientDTO;
import com.citiustech.impact.pms.model.PatientProfile;
import com.citiustech.impact.pms.model.Users;


public interface PatientService {
	
	public String login(String email, String password);

	public String savePatient(PatientDTO p);

	public List<PatientProfile> gettingUserDetails();

	public Users updatingStatus(int id, String status);

	public Optional<PatientProfile> gettinPatientById(int id);

	


	
}
