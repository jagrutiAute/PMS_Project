
package com.citiustech.impact.pms.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
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
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.DTO.PatientDTO;
import com.citiustech.impact.pms.DTO.UsersDTO;
import com.citiustech.impact.pms.model.ISActive;
import com.citiustech.impact.pms.model.PatientProfile;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.PatientProfileRepository;
import com.citiustech.impact.pms.repository.UserRepository;
import com.citiustech.impact.pms.service.PatientService;

@CrossOrigin(origins = "*")
@RestController
public class AccountController {

	static Logger log = Logger.getLogger(AccountController.class.getName());

	@Autowired
	private PatientService patientService;

	@Autowired
	UserRepository userRepo;

	@Autowired
	private PatientProfileRepository patientProfileRepository;

	@PostMapping("/register")
	public String patienRegister(@RequestBody PatientDTO p) {

		log.debug("Hello this is a debug message");
		log.info("Hello this is an info message");

		return patientService.savePatient(p);

	}

	@GetMapping("/getUser/{email}")
	public ResponseEntity<Users> getUser(@PathVariable String email) {
		
		return new ResponseEntity<Users>(userRepo.findByEmail(email), HttpStatus.OK);

	}

	@GetMapping("/patient")
	public ResponseEntity<List<PatientProfile>> getUserDetails() {

		List<PatientProfile> patientProfile = this.patientService.gettingUserDetails();
		return new ResponseEntity<List<PatientProfile>>(patientProfile, HttpStatus.OK);

	}
	
	@GetMapping("/patient/{id}")
	public Optional<PatientProfile> getPatientDetailsById(@PathVariable int id) {
		
		System.out.println("Patient By Id");
		return this.patientService.gettinPatientById(id);
	}

	@DeleteMapping("patient/{id}")
	public void deletePatient(@PathVariable("id") int id, PatientProfile patientProfile) {
		patientProfile.setId((long) id);
		patientProfileRepository.deleteById((long) id);
	}

	@PutMapping("/patient/{id}/{status}")
	public Users updateStatusPatientById(@PathVariable int id, @PathVariable String status) {
		System.out.println(id);
		System.out.println(status);
		//userDTO.getIsActive();
		//ISActive isActive = user.getIsActive();
		patientService.updatingStatus(id, status);
		return null;
	}
	
	

}
