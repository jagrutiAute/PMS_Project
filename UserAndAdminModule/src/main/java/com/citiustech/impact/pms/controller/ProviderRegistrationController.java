package com.citiustech.impact.pms.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.DTO.ProviderRegistrationDTO;
import com.citiustech.impact.pms.model.ProviderRegistration;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.service.EmailService;
import com.citiustech.impact.pms.service.ProviderRegistrationService;
import com.citiustech.impact.pms.service.RoleService;
import com.citiustech.impact.pms.service.UserRegistrationService;

@RestController
@CrossOrigin(origins = "*")
public class ProviderRegistrationController {

	@Autowired
	ProviderRegistrationService providerRegService;

	

	@Autowired
	UserRegistrationService userRegService;



	@PostMapping("/registerProvider")
	public ResponseEntity<String> registerProvider(@RequestBody ProviderRegistrationDTO regProvider) {

	
		
		String status = providerRegService.registerProvider(regProvider, regProvider.getUsername());

		return new ResponseEntity<String>(status,HttpStatus.OK);

	}

}
