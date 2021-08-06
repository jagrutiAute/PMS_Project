package com.citiustech.impact.pms.allergies.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.allergies.model.Allergy;
import com.citiustech.impact.pms.allergies.service.AllergyDetailService;

@RestController
@CrossOrigin(origins = "*")
public class AllergyController {
	
	@Autowired
	AllergyDetailService allergyDetailServie;

	@GetMapping("/getAllergyDetails/{id}")
	public ResponseEntity<Allergy> getAllergyDetails(@PathVariable int id){
		
		Optional<Allergy> allergy =  allergyDetailServie.getAllergyDetails(id);
	
		return new ResponseEntity<Allergy>(allergy.get(),HttpStatus.OK);
		
	}
	
}
