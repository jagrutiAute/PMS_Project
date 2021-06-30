package com.citiustech.impact.pms.loginservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.logindomain.Login;
import com.citiustech.impact.pms.loginrepository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository repo;
  
  public Login login(String username, String password) 
  {
	  Login user = repo.findByUsernameAndPassword(username, password);

  	   return user;
  }
	
 
}