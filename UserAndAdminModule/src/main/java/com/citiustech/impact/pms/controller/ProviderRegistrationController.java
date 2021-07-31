package com.citiustech.impact.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.DTO.ProviderRegistrationDTO;
import com.citiustech.impact.pms.service.ProviderRegistrationService;

@RestController
@CrossOrigin(origins = "*")
public class ProviderRegistrationController {

	@Autowired
	ProviderRegistrationService providerRegService;



	@PostMapping("/registerProvider")
	public ResponseEntity<String> registerProvider(@RequestBody ProviderRegistrationDTO regProvider) {

	
		
		String status = providerRegService.registerProvider(regProvider, regProvider.getUsername());

		return new ResponseEntity<String>(status,HttpStatus.OK);

	}

}
