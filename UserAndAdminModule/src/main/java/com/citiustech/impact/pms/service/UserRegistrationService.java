package com.citiustech.impact.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.UserRepository;

@Service
public class UserRegistrationService {

	@Autowired
	UserRepository userRepository;
	
	public Users saveUser(Users user) {
		
		 		
		return userRepository.save(user);
		
	}
	
}
