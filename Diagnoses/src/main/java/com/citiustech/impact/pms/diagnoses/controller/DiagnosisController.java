package com.citiustech.impact.pms.diagnoses.controller;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.diagnoses.model.Diagnoses;
import com.citiustech.impact.pms.diagnoses.service.DiagnosisService;

@RestController
@CrossOrigin(origins = "*")
public class DiagnosisController {
	
	static Logger log = Logger.getLogger(DiagnosisController.class.getName());

	
	@Autowired
	DiagnosisService diagnosisService;
	
	@GetMapping("/getDiagnosisDetails/{id}")
	public ResponseEntity<Diagnoses> getDiagnosisDetails(@PathVariable int id) {
		
		log.debug("inside getDiagnosisDetails() method of DiagnosisController class");
		log.debug("calling getDiagnosisDetails() method of DiagnosisService class");
		
		Optional<Diagnoses> diagnosis = diagnosisService.getDiagnosisDetails(id);
		
		return new ResponseEntity<Diagnoses>(diagnosis.get(),HttpStatus.OK);
		
	}

}
