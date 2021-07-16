package com.citiustech.impact.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.LoginDTO;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.service.LoginService;

/*
 * 
 * Created Rest End Point for login page.
 * 
*/

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	private LoginService userService;

	@PostMapping("/login")
	public Integer check(@RequestBody LoginDTO log) {

		System.out.println("++++++++ "+log);
		Users loginResult=userService.login(log.getEmail(), log.getPassword());
		//loginResult.setLoginAttempts(2);
	//	System.out.println(loginResult.getLoginAttempts());
		
		return loginResult.getLoginAttempts();
		
		
	}
	
	

}
