package com.citiustech.impact.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.service.ForgotPassService;

@RestController
@CrossOrigin(origins = "*")
public class ForgotPasswordController {

	@Autowired
	ForgotPassService forgotPassService;

	@GetMapping("/forgotPass/{email}")
	public ResponseEntity<String>  forgotPassword(@PathVariable String email) {

		System.out.println("forgotPassController"+forgotPassService.forgotPassword(email));

			return	new ResponseEntity<String> (forgotPassService.forgotPassword(email),HttpStatus.OK);
	}

}
