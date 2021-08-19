package com.citiustech.impact.pms.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.PatientProfile;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.UserRepository;
import com.citiustech.impact.pms.service.PatientService;

@CrossOrigin(origins = "*")
@RestController
public class PatientUserController {

	static Logger log = Logger.getLogger(PatientUserController.class.getName());
 
	@Autowired
	private PatientService patientService;

	@Autowired
	UserRepository userRepo;

	@GetMapping("/patient")
	public ResponseEntity<List<PatientProfile>> getUserDetails() {
		
		log.debug("inside getUserDetails() method of PatientUserController");
		log.debug("calling gettingUserDetails() method of PatientService");
		List<PatientProfile> patientProfile = this.patientService.gettingUserDetails();
		return new ResponseEntity<List<PatientProfile>>(patientProfile, HttpStatus.OK);

	}

	@GetMapping("/patient/{id}")
	public Optional<PatientProfile> getPatientDetailsById(@PathVariable int id) {

		System.out.println("Patient By Id");
		return this.patientService.gettinPatientById(id);
	}

	/*
	 * @DeleteMapping("patient/{id}") public void deletePatient(@PathVariable("id")
	 * int id, PatientProfile patientProfile) { patientProfile.setId((long) id);
	 * patientProfileRepository.deleteById((long) id); }
	 */

	@PutMapping("/patient/{id}/{status}")
	public Users updateStatusPatientById(@PathVariable int id, @PathVariable String status) {
		System.out.println(id);
		System.out.println(status);
		// userDTO.getIsActive();
		// ISActive isActive = user.getIsActive();
		patientService.updatingStatus(id, status);
		return null;
	}
}
