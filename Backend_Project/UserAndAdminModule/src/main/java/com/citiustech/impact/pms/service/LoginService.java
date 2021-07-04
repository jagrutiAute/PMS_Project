package com.citiustech.impact.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.citiustech.impact.pms.model.Login;
import com.citiustech.impact.pms.repository.LoginRepository;

/*
 * 
 * Created service class to validate the valid user.
 * 
*/

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository repo;
  
  public Login login(String email, String password) 
  {
	  Login user = repo.findByEmailAndPassword(email, password);
  	   return user;
  }
	
 
}