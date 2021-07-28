package com.citiustech.impact.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.PatientDetails;
import com.citiustech.impact.pms.service.PatientDetailsService;

@RestController
public class PatientDetailsController {

	@Autowired
	PatientDetailsService pataientDetailsService;

	@PostMapping("/savePatientDetails")
	public ResponseEntity<PatientDetails> savePatientDetails(@RequestBody PatientDetails patientdetails) {

		PatientDetails patientDetails = pataientDetailsService.savePatientDetails(patientdetails);

		return new ResponseEntity<PatientDetails>(patientDetails, HttpStatus.CREATED);

	}
}
