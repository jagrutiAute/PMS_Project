package com.citiustech.impact.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.Medication;
import com.citiustech.impact.pms.repository.MedicationRepo;

@RestController
public class MedicationController {

	@Autowired
	private MedicationRepo medicationRepo;
	
	@GetMapping("physician/medication")
	public ResponseEntity<List<Medication>> getMedicationDetails(){
		
		List<Medication> medication = medicationRepo.findAll();
		return new ResponseEntity<List<Medication>>(medication, HttpStatus.OK);
	}
}
