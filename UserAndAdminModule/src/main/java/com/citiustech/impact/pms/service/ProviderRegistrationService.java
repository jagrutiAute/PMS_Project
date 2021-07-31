package com.citiustech.impact.pms.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.DTO.ProviderRegistrationDTO;
import com.citiustech.impact.pms.model.ProviderRegistration;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.ProviderRegistrationRepository;
import com.citiustech.impact.pms.repository.UserRepository;

@Service
public class ProviderRegistrationService {

	@Autowired
	ProviderRegistrationRepository providerRegRepo;

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RoleService role;
	
	@Autowired
	EmailService emailService;
	
	

	public String registerProvider(ProviderRegistrationDTO regProvider, String email) {

		ProviderRegistration providerReg = providerRegRepo.findByEmployeeid(regProvider.getEmployeeid());
		Users users = userRepo.findByEmail(email);
				
		if ((providerReg == null)&&(users==null)) {
			
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

			ProviderRegistration status = providerRegRepo.save(provider);
			
			return "SUCCESS";

		}
		
		if(users!=null && providerReg!=null) {
			return "EMAIL_EMPLOYEEID";
		}
		else if((providerReg != null)){
			return "EMPLOYEEID";
		}else if((users !=null)) {
			return "EMAIL";
		}
		
		
		return "FAIL";

	}

}