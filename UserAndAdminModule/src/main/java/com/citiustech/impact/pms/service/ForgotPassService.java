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

	public String forgotPassword(String email) {

		Users user = userRepo.findByEmail(email);

		if (user != null) {

			String generatedString = RandomStringUtils.random(10, true, true).concat("$");

			System.out.println("generatedString  ::  " + generatedString);

			
			/*
			 * send("impactpmsjavabatch1@gmail.com", "amit@1234", email,
			 * "Reset Pasword OTP ", "Your one time password is " + generatedString);
			 */
			 

			user.setPassword(generatedString);
			user.setPassowrdChangedStatus(1);

			userRepo.save(user);

			return "Success";
		}

		return "failed";
	}

	public static void send(final String from, final String password, String to, String sub, String msg) {
		// Get properties object
		System.out.println("inside send() method");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
