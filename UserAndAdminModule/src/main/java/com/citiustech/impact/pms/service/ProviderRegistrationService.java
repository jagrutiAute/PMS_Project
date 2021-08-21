package com.citiustech.impact.pms.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.DTO.ProviderRegistrationDTO;
import com.citiustech.impact.pms.controller.ProviderRegistrationController;
import com.citiustech.impact.pms.model.ISActive;
import com.citiustech.impact.pms.model.ProviderRegistration;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.ProviderRegistrationRepository;
import com.citiustech.impact.pms.repository.UserRepository;

@Service
public class ProviderRegistrationService {

	static Logger log = Logger.getLogger(ProviderRegistrationController.class.getName());

	@Autowired
	ProviderRegistrationRepository providerRegRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	RoleService role;

	@Autowired
	UserRegistrationService userRegService;

	@Autowired
	EmailService emailService;

	public String registerProvider(ProviderRegistrationDTO regProvider, String email) {

		log.debug("inside registerProvider() method of ProviderRegistrationService class ");
		log.debug("calling findByEmployeeid() method of ProviderRegistrationRepository interface");

		ProviderRegistration providerReg = providerRegRepo.findByEmployeeid(regProvider.getEmployeeid());

		log.debug("calling findByEmail() method of UserRepository interface");

		Users users = userRepo.findByEmail(email);

		if ((providerReg == null) && (users == null)) {
			Users user = new Users();
			user.setEmail(regProvider.getUsername());
			user.setRole(role.getRoles().get(regProvider.getRole()));
			user.setIsActive(ISActive.ACTIVE);
			String generatedString = RandomStringUtils.random(10, true, true).concat("$");
			System.out.println("password== "+generatedString);
			/*
			 * emailService.sendEmail("impactpmsjavabatch1@gmail.com", "amit@1234",
			 * regProvider.getUsername(), "Reset Pasword OTP ", "Your one time password is "
			 * + generatedString);
			 */
			// System.out.println(generatedString);
			log.debug("calling static encryption() method of PatientServiceImpl class");
			String pwd = PatientServiceImpl.encryption(regProvider.getUsername(), generatedString);
			user.setPassword(pwd);

			ProviderRegistration provider = new ProviderRegistration();

			provider.setTitle(regProvider.getTitle());
			provider.setFirstName(regProvider.getFirstName());
			provider.setLastName(regProvider.getLastName());
			provider.setDate_of_birth(regProvider.getDate_of_birth());
			provider.setEmployeeid(regProvider.getEmployeeid());
			provider.setUser(user);

			log.debug("calling  save() method of ProviderRegistrationRepository interface");
			ProviderRegistration status = providerRegRepo.save(provider);

			return "SUCCESS";

		}

		if ((providerReg != null)) {

			return "EMPLOYEEID";
		} else if ((users != null)) {
			return "EMAIL";
		}

		return "FAIL";

	}

}