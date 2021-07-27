
package com.citiustech.impact.pms.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.DTO.PatientDTO;
import com.citiustech.impact.pms.service.PatientService;

@RestController
@CrossOrigin(origins = "*")
public class AccountController {

	static Logger log = Logger.getLogger(AccountController.class.getName());

	@Autowired
	private PatientService patientService;

	@PostMapping("/register")
	public String patienRegister(@RequestBody PatientDTO p) {

		log.debug("Hello this is a debug message");
		log.info("Hello this is an info message");

		return patientService.savePatient(p);

	}

}
