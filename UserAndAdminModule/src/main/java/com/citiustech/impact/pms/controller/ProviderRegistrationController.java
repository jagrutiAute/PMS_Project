package com.citiustech.impact.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.DTO.ProviderRegistrationDTO;
import com.citiustech.impact.pms.model.ProviderRegistration;
import com.citiustech.impact.pms.model.Users;
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

	@PostMapping("/registerProvider")
	public boolean registerProvider(@RequestBody ProviderRegistrationDTO regProvider) {

		Users user = new Users();
		user.setEmail(regProvider.getUsername());
		user.setRole(role.getRoles().get(regProvider.getRole()));
		user.setPassword("password@1234");

		userRegService.saveUser(user);

		ProviderRegistration provider = new ProviderRegistration();

		provider.setTitle(regProvider.getTitle());
		provider.setFirstName(regProvider.getFirstName());
		provider.setLastName(regProvider.getLastName());
		provider.setDate_of_birth(regProvider.getDate_of_birth());
		provider.setEmployeeid(regProvider.getEmployeeid());
		provider.setUser(user);
		boolean status = providerRegService.registerProvider(provider,regProvider.getUsername());
		
		return status;

	}

	
}
