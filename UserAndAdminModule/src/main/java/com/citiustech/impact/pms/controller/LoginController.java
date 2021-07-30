package com.citiustech.impact.pms.controller;

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
import com.mysql.cj.log.LogFactory;

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
	public ResponseEntity<String> check(@RequestBody LoginDTO log) {

		System.out.println("++++++++ " + log);
		Users loginResult = userService.login(log.getEmail());

		System.out.println("loginResult  ::  " + loginResult);

		if (loginResult == null) {
			return new ResponseEntity<String>("UsernamePass",HttpStatus.OK);
		}

			if (loginResult.getIsActive() == ISActive.BLOCK) {

				System.out.println("already blocked");
				// return status your account has blocked contact Admin

				return new ResponseEntity<String>("BLOCKED", HttpStatus.OK);

			}

			System.out.println(loginResult.getLoginAttempts());

			int n = loginResult.getLoginAttempts();
			
		

			if (!loginResult.getPassword().equals(log.getPassword())) {

				if (n == 2) {

					loginResult.setIsActive(ISActive.BLOCK);

					userService.blockUser(loginResult);
					System.out.println(loginResult);

					System.out.println("your account has blocked");

					return new ResponseEntity<String>("BLOCKED", HttpStatus.OK);

				} else {

					loginResult.setLoginAttempts(n + 1);

					Users re = userService.updatefaildeLogin(loginResult);

					return new ResponseEntity<String>(String.valueOf(re.getLoginAttempts()), HttpStatus.OK);

				}

			}
			
		 else {
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}

	}

}
