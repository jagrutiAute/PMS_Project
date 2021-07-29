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
	RoleService role;

	@Autowired
	UserRegistrationService userRegService;

	@Autowired
	EmailService emailService;

	@PostMapping("/registerProvider")
	public ResponseEntity<String> registerProvider(@RequestBody ProviderRegistrationDTO regProvider) {

		Users user = new Users();
		user.setEmail(regProvider.getUsername());
		user.setRole(role.getRoles().get(regProvider.getRole()));
		String generatedString = RandomStringUtils.random(10, true, true).concat("$");
		
		/*
		 * emailService.sendEmail("impactpmsjavabatch1@gmail.com", "amit@1234",
		 * regProvider.getUsername(), "Reset Pasword OTP ", "Your one time password is "
		 * + generatedString);
		 */

		user.setPassword(generatedString);

	
		ProviderRegistration provider = new ProviderRegistration();

		provider.setTitle(regProvider.getTitle());
		provider.setFirstName(regProvider.getFirstName());
		provider.setLastName(regProvider.getLastName());
		provider.setDate_of_birth(regProvider.getDate_of_birth());
		provider.setEmployeeid(regProvider.getEmployeeid());
		provider.setUser(user);
		
		String status = providerRegService.registerProvider(provider, regProvider.getUsername());

		return new ResponseEntity<String>(status,HttpStatus.OK);

	}

}
