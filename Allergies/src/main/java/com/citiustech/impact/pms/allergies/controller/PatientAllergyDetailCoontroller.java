package com.citiustech.impact.pms.allergies.controller;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.allergies.model.AllergyDetails;
import com.citiustech.impact.pms.allergies.service.AllergyDetailService;

@RestController
@CrossOrigin(origins = "*")
public class PatientAllergyDetailCoontroller {

	static Logger log = Logger.getLogger(PatientAllergyDetailCoontroller.class.getName());

	
	@Autowired
	AllergyDetailService allergyDetailService;

	@PostMapping("savePatientAllergyDetails")
	public ResponseEntity<AllergyDetails> savePatientAllergyDetails(@RequestBody AllergyDetails allergyDetails) {

		log.debug("inside savePatientAllergyDetails() method of PatientAllergyDetailCoontroller class");
		log.debug("calling addPatientAllergy() method of AllergyDetailService class");
		
		
		AllergyDetails allergyDetail = allergyDetailService.addPatientAllergy(allergyDetails);

		return new ResponseEntity<AllergyDetails>(allergyDetail, HttpStatus.OK);

	}
	
	@GetMapping("/getPatientAllergyDetails/{id}")
	public ResponseEntity<AllergyDetails> getPatientAllergyDetails(@PathVariable int id){
		
		log.debug("inside getPatientAllergyDetails() method of PatientAllergyDetailCoontroller class");
		log.debug("calling fetchPatientAllergyDetails() method of AllergyDetailService class");
		
		
	Optional<AllergyDetails> allergyDetails = allergyDetailService.fetchPatientAllergyDetails(id);
		
	return new ResponseEntity<AllergyDetails>(allergyDetails.get(),HttpStatus.OK);
		
	}
	
	
}
