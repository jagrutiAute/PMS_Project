package com.citiustech.impact.pms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.PatientUser;
import com.citiustech.impact.pms.service.PatientUserService;



@CrossOrigin(origins = "*")
@RestController

public class PatientUserController {

	@Autowired
	private PatientUserService patientUserService;
	
	
	public static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PatientUserController.class.getName());
	
	@GetMapping("/patient")
	public ResponseEntity<List<PatientUser>> getPatientDetails() {
		
		
		log.info("All Patient Details");
		List<PatientUser> patientDetails = this.patientUserService.gettinPatient();
		
		return new ResponseEntity<List<PatientUser>>(patientDetails, HttpStatus.OK);
	}
	
	@GetMapping("/patient/{id}")
	public Optional<PatientUser> getPatientDetailsById(@PathVariable int id) {
		
		System.out.println("Patient By Id");
		return this.patientUserService.gettinPatientById(id);
	}
	
	@PostMapping("/patient")
	public PatientUser addCourse(@RequestBody PatientUser patient) {
		System.out.println(patient);
		return this.patientUserService.addingCourse(patient) ;
	}
	
	@PutMapping("/patient/{id}")
	public PatientUser updatePatientById(@RequestBody PatientUser patient) {
		System.out.println(patient);
		return this.patientUserService.updatingPatientById(patient) ;
	}
	
	@DeleteMapping("patient/{id}")
	public void deletePatient(@PathVariable("id") int id,PatientUser patient) {
		patient.setId(id);
		patientUserService.deletePatient(patient);
	}
}
