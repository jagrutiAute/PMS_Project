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

		logger.trace("Initializaing check() method ");
		logger.trace("calling encryption() method to encrypt password");

		String pwd = PatientServiceImpl.encryption(log.getEmail(), log.getPassword());

		logger.debug(PatientServiceImpl.encryption(log.getEmail(), log.getPassword()));

		logger.trace("calling login() method ");
		Users loginResult = userService.login(log.getEmail(), pwd);
		logger.info("login info " + loginResult);

		if (loginResult == null) {
			logger.error("user doesn't exist in system");
			return new ResponseEntity<String>("UsernamePass", HttpStatus.OK);

		}

		if (loginResult.getIsActive() == ISActive.BLOCK) {

			logger.info("user status is blocked");
			return new ResponseEntity<String>("BLOCKED", HttpStatus.OK);

		}

		logger.warn("user attements is :" +loginResult.getLoginAttempts() + " after providng 3 time wrong credentials user will enter into block state");

		int n = loginResult.getLoginAttempts();

		logger.trace("check the password is wrong");
		if (!loginResult.getPassword().equals(pwd)) {
		logger.debug("Wrong attempt count" + n);
			if (n == 2) {
				logger.info("3 wrong attempt , user status set as block");
				loginResult.setIsActive(ISActive.BLOCK);
				logger.trace("calling blockUser() method");
				userService.blockUser(loginResult);
				
				logger.error("Account has blocked due to 3 time wrong attempts");
			

				return new ResponseEntity<String>("BLOCKED", HttpStatus.OK);

			} else {

				logger.trace("set the login attempts count");
				loginResult.setLoginAttempts(n + 1);
				logger.trace("calling updatefaildeLogin method");
				Users re = userService.updatefaildeLogin(loginResult);
				logger.debug(userService.updatefaildeLogin(loginResult));

				return new ResponseEntity<String>(String.valueOf(re.getLoginAttempts()), HttpStatus.OK);

			}

		}

		else {
			if(loginResult.getLoginAttempts()>0) {
				loginResult.setLoginAttempts(0);
				userService.updatefaildeLogin(loginResult);
			}
			logger.trace("User validate successfully");
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		

	}

}
