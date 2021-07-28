package com.citiustech.impact.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.PatientDetails;
import com.citiustech.impact.pms.repository.PatientDetailsRepository;
import com.citiustech.impact.pms.repository.UserRepository;

@Service
public class PatientDetailsService {

	@Autowired
	PatientDetailsRepository patientDetailsRepo;
	
	
	public PatientDetails savePatientDetails(PatientDetails patientDetails) {
		System.out.println("Inside service"+patientDetails);

		PatientDetails patientDetailsSer = patientDetailsRepo.save(patientDetails);
		
		System.out.println("patientDetailsSer::::::");

		return patientDetailsSer;

	}
}
