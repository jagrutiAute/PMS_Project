<<<<<<< HEAD
package com.citiustech.impact.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.Patient;
<<<<<<< HEAD
<<<<<<< HEAD
import com.citiustech.impact.pms.model.Users;
=======
import com.citiustech.impact.pms.model.User;
>>>>>>> b707ea0bb99d2dafbba5d70514928c2fbc430850
=======
import com.citiustech.impact.pms.model.User;
>>>>>>> ebdf04721f462af1cc6faab3a2c978d371240229
import com.citiustech.impact.pms.service.PatientService;


@RestController
@CrossOrigin(origins = "*")
public class AccountController {

	@Autowired
	private PatientService patientService;

	

<<<<<<< HEAD
<<<<<<< HEAD
	
=======
=======
>>>>>>> ebdf04721f462af1cc6faab3a2c978d371240229
	@PostMapping("/login")
	public String check(@RequestBody User user) {

		String loginResult=patientService.login(user.getEmailID(), user.getPassword());

		
		return loginResult;
		
		
	}
<<<<<<< HEAD
>>>>>>> b707ea0bb99d2dafbba5d70514928c2fbc430850
=======
	 
	@PostMapping("/register")
	public String patienRegister(@RequestBody Patient p) {
		
		System.out.println(p);

	
	    return patientService.addPatient(p);
			   

	}
	
	
	 
	
}
||||||| 78dff94
=======
package com.citiustech.impact.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.Patient;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.service.PatientService;


@RestController
@CrossOrigin(origins = "*")
public class AccountController {

	@Autowired
	private PatientService patientService;

	

	
>>>>>>> ebdf04721f462af1cc6faab3a2c978d371240229
	 
	@PostMapping("/register")
	public String patienRegister(@RequestBody Patient p) {
		
		System.out.println(p);

	
	    return patientService.addPatient(p);
			   

	}
	
	
	 
	
}
>>>>>>> 8c23b399729fd76973e53460bbd8c7cc648c8d6f
