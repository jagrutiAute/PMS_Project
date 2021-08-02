package com.citiustech.impact.pms.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.UserRepository;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

@Service
public class ForgotPassService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	EmailService emailService;

	public String forgotPassword(String email) {

		Users user = userRepo.findByEmail(email);

		if (user != null) {

			String generatedString = RandomStringUtils.randomNumeric(1, 1).concat(RandomStringUtils.randomAlphanumeric(7,14)).concat("$");

			System.out.println("generatedString  ::  " + generatedString);

			/*
			 * send("impactpmsjavabatch1@gmail.com", "amit@1234", email,
			 * "Reset Pasword OTP ", "Your one time password is " + generatedString);
			 */
			emailService.sendEmail("impactpmsjavabatch1@gmail.com","amit@1234",email,"Reset Pasword OTP ", "Your one time password is " + generatedString);

			String pwd=PatientServiceImpl.encryption(email,generatedString);
			user.setPassword(pwd);
			user.setPassowrdChangedStatus(1);

			userRepo.save(user);

			return "Success";
		}

		return "failed";
	}

	

}
