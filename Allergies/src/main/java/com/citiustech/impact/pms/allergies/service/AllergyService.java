package com.citiustech.impact.pms.allergies.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.allergies.model.Allergy;
import com.citiustech.impact.pms.allergies.repository.AllergyRepository;

@Service
public class AllergyService {
	
	static Logger log = Logger.getLogger(AllergyService.class.getName());

	@Autowired
	AllergyRepository allergyDetailsRepo;

	public Optional<Allergy> getAllergyDetails(int id) {
		
		log.debug("inside getAllergyDetails() method of AllergyService class");
		log.debug("calling findById() method of AllergyRepository interface");
		
		return allergyDetailsRepo.findById(id);
		
	}

}
