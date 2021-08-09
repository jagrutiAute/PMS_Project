
package com.citiustech.impact.pms.controller;

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

import com.citiustech.impact.pms.DTO.PatientDTO;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.UserRepository;
import com.citiustech.impact.pms.service.PatientService;

@RestController
public class AccountController {

	static Logger log = Logger.getLogger(AccountController.class.getName());

	@Autowired
	private PatientService patientService;

	@Autowired
	UserRepository userRepo;

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

}
