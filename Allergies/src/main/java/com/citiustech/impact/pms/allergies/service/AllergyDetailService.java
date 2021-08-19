package com.citiustech.impact.pms.allergies.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.allergies.model.AllergyDetails;
import com.citiustech.impact.pms.allergies.repository.AllergyDetailsRepository;

@Service
public class AllergyDetailService {

	static Logger log = Logger.getLogger(AllergyDetailService.class.getName());

	@Autowired
	AllergyDetailsRepository allergyDetailsRepo;
	
	public AllergyDetails addPatientAllergy(AllergyDetails allergyDetails) {
						
		log.debug("inside addPatientAllergy() method of AllergyDetailService class");
		log.debug("calling save() method of AllergyDetailsRepository interface");
		
		return allergyDetailsRepo.save(allergyDetails);
			
	}

	public Optional<AllergyDetails> fetchPatientAllergyDetails(int id) {
		
		log.debug("inside fetchPatientAllergyDetails() method of AllergyDetailService class");
		log.debug("calling findById() method of AllergyDetailsRepository interface");
		
		return allergyDetailsRepo.findById(id);
	
	}

}
