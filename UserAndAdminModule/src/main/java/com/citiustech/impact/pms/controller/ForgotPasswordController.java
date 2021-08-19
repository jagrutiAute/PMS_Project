package com.citiustech.impact.pms.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.service.ForgotPassService;
import com.citiustech.impact.pms.service.PatientServiceImpl;

@RestController
public class ForgotPasswordController {

	static Logger log = Logger.getLogger(ForgotPasswordController.class.getName());

	
	@Autowired
	ForgotPassService forgotPassService;

	@GetMapping("/forgotPass/{email}")
	public ResponseEntity<String>  forgotPassword(@PathVariable String email) {

		//System.out.println("forgotPassController"+forgotPassService.forgotPassword(email));
		log.debug("inside forgotPassword() method");
		log.debug("calling forgotPassword() method of ForgotPassService class");
			return	new ResponseEntity<String> (forgotPassService.forgotPassword(email),HttpStatus.OK);
	}

}
