package com.citiustech.impact.pms.allergies.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.allergies.model.AllergyDetails;
import com.citiustech.impact.pms.allergies.repository.AllergyDetailsRepository;

@Service
public class AllergyDetailService {

	@Autowired
	AllergyDetailsRepository allergyDetailsRepo;
	
	public AllergyDetails addPatientAllergy(AllergyDetails allergyDetails) {
						
		return allergyDetailsRepo.save(allergyDetails);
			
	}

	public Optional<AllergyDetails> fetchPatientAllergyDetails(int id) {
		
		
		return allergyDetailsRepo.findById(id);
	
	}

}
