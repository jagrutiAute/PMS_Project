package com.citiustech.impact.pms.procedure.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.procedure.model.PatientProcedure;
import com.citiustech.impact.pms.procedure.service.PatientProcedureService;

@RestController
@CrossOrigin(origins = "*")
public class PatientProcedureController {

	@Autowired
	PatientProcedureService patientProcedureService;

	@PostMapping("/savePatientProcedure")
	public ResponseEntity<PatientProcedure> savePatientProcedure(@RequestBody PatientProcedure patientProcedure) {

		PatientProcedure procPatient = patientProcedureService.addPatientProcedure(patientProcedure);

		return new ResponseEntity<PatientProcedure>(procPatient, HttpStatus.OK);

	}
	
	@GetMapping("/getPatientProcedure/{id}")
	public ResponseEntity<PatientProcedure> getPatientProcedure(@PathVariable Integer id) {
		
		Optional<PatientProcedure> patientProcedure =	patientProcedureService.fetchPatientProcedure(id);
		
		return new ResponseEntity<PatientProcedure>(patientProcedure.get(),HttpStatus.OK);
		
	}
}
