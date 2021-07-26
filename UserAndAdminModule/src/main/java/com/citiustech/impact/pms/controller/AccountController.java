package com.citiustech.impact.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.Patient;
<<<<<<< HEAD
import com.citiustech.impact.pms.model.Users;
=======
import com.citiustech.impact.pms.model.User;
>>>>>>> b707ea0bb99d2dafbba5d70514928c2fbc430850
import com.citiustech.impact.pms.service.PatientService;


@RestController
@CrossOrigin(origins = "*")
public class AccountController {

	@Autowired
	private PatientService patientService;

	

<<<<<<< HEAD
	
=======
	@PostMapping("/login")
	public String check(@RequestBody User user) {

		String loginResult=patientService.login(user.getEmailID(), user.getPassword());

		
		return loginResult;
		
		
	}
>>>>>>> b707ea0bb99d2dafbba5d70514928c2fbc430850
	 
	@PostMapping("/register")
	public String patienRegister(@RequestBody Patient p) {
		
		System.out.println(p);

	
	    return patientService.addPatient(p);
			   

	}
	
	
	 
	
}