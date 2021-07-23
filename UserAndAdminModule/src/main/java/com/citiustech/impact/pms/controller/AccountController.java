package com.citiustech.impact.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.Patient;
import com.citiustech.impact.pms.model.User;
import com.citiustech.impact.pms.service.PatientService;


@RestController
@CrossOrigin(origins = "*")
public class AccountController {

	@Autowired
	private PatientService patientService;

	

	@PostMapping("/login")
	public String check(@RequestBody User user) {

		String loginResult=patientService.login(user.getEmailID(), user.getPassword());

		
		return loginResult;
		
		
	}
	 
	@PostMapping("/register")
	public String patienRegister(@RequestBody Patient p) {
		
		System.out.println(p);

	
	    return patientService.addPatient(p);
			   

	}
	
	
	 
	
}