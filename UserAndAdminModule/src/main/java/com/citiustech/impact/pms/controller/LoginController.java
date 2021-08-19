package com.citiustech.impact.pms.controller;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.DTO.LoginDTO;
import com.citiustech.impact.pms.model.ISActive;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.service.LoginService;
import com.citiustech.impact.pms.service.PatientServiceImpl;
import com.mysql.cj.log.LogFactory;

/*
 * 
 * Created Rest End Point for login page.
 * 
*/

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

	private static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService userService;

	@PostMapping("/login")
	public ResponseEntity<String> check(@RequestBody LoginDTO log) {
		PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "log4j.properties");

		logger.trace("Calling check() method of LoginController Class");
		logger.trace("Calling encryption() method of PatientServiceImpl class to encrypt password");

		String pwd = PatientServiceImpl.encryption(log.getEmail(), log.getPassword());

	
		logger.trace("Calling login() method of LoginService class");
		Users loginResult = userService.login(log.getEmail(), pwd);
		
		logger.info("Check wether user exist in system or not" );

		if (loginResult == null) {
			logger.error("User doesn't exist in system");
			return new ResponseEntity<String>("UsernamePass", HttpStatus.OK);

		}
		
		
		logger.info("Check wether user already blocked or not" );
		if (loginResult.getIsActive() == ISActive.BLOCK) {

			logger.warn("user status is blocked");
			return new ResponseEntity<String>("BLOCKED", HttpStatus.OK);

		}

		logger.warn("Calling getLoginAttempts() to get the count of login attempts");

		int n = loginResult.getLoginAttempts();

		logger.trace("Check the password is wrong or not");
		if (!loginResult.getPassword().equals(pwd)) {
		logger.debug("Wrong attempt count" + n);
			if (n == 2) {
				logger.info("3 wrong attempt , user status set as block");
				loginResult.setIsActive(ISActive.BLOCK);
				logger.trace("Calling blockUser() method to block ther user");
				userService.blockUser(loginResult);
				
				logger.error("Account has blocked due to 3 time wrong attempts");
			

				return new ResponseEntity<String>("BLOCKED", HttpStatus.OK);

			} else {

				logger.trace("Set the login attempts count");
				loginResult.setLoginAttempts(n + 1);
				logger.trace("Calling updatefaildeLogin() method");
				Users re = userService.updatefaildeLogin(loginResult);
				return new ResponseEntity<String>(String.valueOf(re.getLoginAttempts()), HttpStatus.OK);

			}

		}

		else {
			logger.trace("Calling getLoginAttempts() method  to check loginattempts>0 or not");
			if(loginResult.getLoginAttempts()>0) {
				loginResult.setLoginAttempts(0);
				userService.updatefaildeLogin(loginResult);
			}
			logger.trace("User validate successfully");
			
			
			if(loginResult.getRole() == null) {
				
				return new ResponseEntity<String>("Patient", HttpStatus.OK);
				
			}else {
				
				System.out.println("loginResult.getRole().getRoleName()  ::::  "+loginResult.getRole().getRoleName());
								
				return new ResponseEntity<String>(loginResult.getRole().getRoleName(), HttpStatus.OK);
				
			}
			
			
		}
		

	}

}
