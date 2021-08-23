package com.citiustech.impact.pms.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.UserRepository;

@Service
public class ForgotPassService {

	static Logger log = Logger.getLogger(ForgotPassService.class.getName());

	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	EmailService emailService;

	public String forgotPassword(String email) {

		log.debug("inside forgotPassword() method");
		log.debug("calling findByEmail() method of UserRepository interface");
		Users user = userRepo.findByEmail(email);

		if (user != null) {

			String generatedString = RandomStringUtils.randomNumeric(1, 1).concat(RandomStringUtils.randomAlphanumeric(7,14)).concat("$");

			//System.out.println("generatedString  ::  " + generatedString);

			/*
			 * send("impactpmsjavabatch1@gmail.com", "amit@1234", email,
			 * "Reset Pasword OTP ", "Your one time password is " + generatedString);
			 */
			log.debug("calling sendEmail() method of EmailService class");
			//emailService.sendEmail("impactpmsjavabatch1@gmail.com","amit@1234",email,"Reset Pasword OTP ", "Your one time password is " + generatedString);
		    
			log.debug("calling static encryption() method of PatientServiceImpl class");
			String pwd=PatientServiceImpl.encryption(email,generatedString);
			user.setPassword(pwd);
			user.setPassowrdChangedStatus(1);
			log.info(generatedString);
			log.debug("calling save() method of UserRepository interface");
			userRepo.save(user);

			return "Success";
		}

		return "failed";
	}

	

}
