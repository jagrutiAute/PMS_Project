package com.citiustech.impact.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.Login;
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
	public String check(@RequestBody Login log) {

		if (userService.login(log.getEmail(), log.getPassword()) != null) {
			return "success";
		} else {
			return "Invalid credential";
		}

	}

}
