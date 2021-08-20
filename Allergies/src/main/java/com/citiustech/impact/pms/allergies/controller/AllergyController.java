package com.citiustech.impact.pms.allergies.controller;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.allergies.model.Allergy;
import com.citiustech.impact.pms.allergies.service.AllergyService;

@RestController
@CrossOrigin(origins = "*")
public class AllergyController {
	
	static Logger log = Logger.getLogger(AllergyController.class.getName());

	@Autowired
	AllergyService allergyDetailServie;

	@GetMapping("/getAllergyDetails/{id}")
	public ResponseEntity<Allergy> getAllergyDetails(@PathVariable int id){
		
		log.debug("inside getAllergyDetails() method of AllergyController class");
		log.debug("calling getAllergyDetails() method of AllergyService class");
		
		Optional<Allergy> allergy =  allergyDetailServie.getAllergyDetails(id);
	
		return new ResponseEntity<Allergy>(allergy.get(),HttpStatus.OK);
		
	}
	
}
