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
		// return allergyDetailsRepo.save(allergyDetails);

	}

	public Optional<List<AllergyDetails>> fetchPatientAllergyDetails(String pid) {

		log.debug("inside fetchPatientAllergyDetails() method of AllergyDetailService class");
		log.debug("calling findById() method of AllergyDetailsRepository interface");

		// return allergyDetailsRepo.findById(pid);
		return allergyDetailsRepo.getAllPrtientAllergies(pid);

	}

	public void deleteAllergies(String pid, Integer id) {

		log.debug("inside deleteAllergies() method of AllergyDetailService class");
		log.debug("calling deletePrtientAllergies() method of AllergyDetailsRepository interface");

	    allergyDetailsRepo.deletePrtientAllergies(pid,id);
		// return allergyDetailsRepo.findById(pid);
		//return allergyDetailsRepo.deletePrtientAllergies(pid,id);

	}

}
