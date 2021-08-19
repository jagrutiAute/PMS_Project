package com.citiustech.impact.pms.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.controller.MedicationController;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.UserRepository;

@Service
public class UserRegistrationService {

	static Logger log = Logger.getLogger(MedicationController.class.getName());

	
	@Autowired
	UserRepository userRepository;
	
	public Users saveUser(Users user) {
		
		log.debug("inside saveUser() method of UserRegistrationService class");
		log.debug("calling save() method of UserRepository interface");

		return userRepository.save(user);
		
	}
	
}
