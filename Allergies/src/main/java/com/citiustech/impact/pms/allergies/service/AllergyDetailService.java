package com.citiustech.impact.pms.allergies.service;

import java.util.List;
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
	
	public List<AllergyDetails> addPatientAllergy(List<AllergyDetails> allergies) {
						
		
		log.debug("inside addPatientAllergy() method of AllergyDetailService class");
		log.debug("calling save() method of AllergyDetailsRepository interface");
		
		return allergyDetailsRepo.saveAll(allergies);
		//return allergyDetailsRepo.save(allergyDetails);
			
	}

	public Optional<AllergyDetails> fetchPatientAllergyDetails(int pid) {
		
		log.debug("inside fetchPatientAllergyDetails() method of AllergyDetailService class");
		log.debug("calling findById() method of AllergyDetailsRepository interface");
		
		return allergyDetailsRepo.findById(pid);
	
	}

}
