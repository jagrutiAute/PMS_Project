package com.citiustech.impact.pms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.PatientDetails;
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

	public PatientDetails updatePatientDetails(PatientDetails patient) {
		// TODO Auto-generated method stub
		return patientDetailsRepo.save(patient);
	}

}
