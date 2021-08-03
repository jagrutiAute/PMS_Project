package com.citiustech.impact.pms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.PatientDetailDTO;
import com.citiustech.impact.pms.model.PatientDetails;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.PatientDetailsRepository;

@Service
public class PatientDetailsService {

	@Autowired
	PatientDetailsRepository patientDetailsRepo;

	public Optional<PatientDetails> getPatientDetails(int id) {

		Optional<PatientDetails> patientDetailsSer = patientDetailsRepo.findById(id);

		System.out.println("patientDetailsSer::::::"+patientDetailsSer);

		return patientDetailsSer;

	}

	public PatientDetails updatePatientDetails(PatientDetailDTO patient) {
		
		PatientDetails patientDetails = new PatientDetails();
		
		Users user = new Users();
		
		patientDetails.setFirstName(patient.getFirstName());
		patientDetails.setLastName(patient.getLastName());
		patientDetails.setDateOfBirth(patient.getDateOfBirth());
		patientDetails.setAge(patient.getAge()); 
		patientDetails.setGender(patient.getGender());  
		patientDetails.setLanguageKnown(patient.getLanguageKnown());   
		patientDetails.setHomeAddress(patient.getHomeAddress()); 
		patientDetails.setRace(patient.getRace());
		patientDetails.setEthinicity(patient.getEthinicity());
		patientDetails.setUser(user);
		  
			
		return patientDetailsRepo.save(patientDetails);
	}

}
