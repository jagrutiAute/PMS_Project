package com.citiustech.impact.pms.logincontroller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.citiustech.impact.pms.logindomain.Login;
import com.citiustech.impact.pms.loginservice.LoginService;

// comment Added by naushad
/*This Class get the login details from angular,validate the user and check the user is existed in database or not 
 * 
 * URL : http://localhost:8080/login?username=test1@gmail.com&password=test1@123
*/

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	private LoginService userService;

	@PostMapping("/login")
	public String check(@RequestBody Login log) {
		// System.out.println("in"+log);

	
		if (userService.login(log.getEmail(), log.getPassword()) != null) {
			return "success";
		} else {
			return "Invalid credential";
		}

	}

	/*
	 * @GetMapping("/login/{user}") public String login(@PathVariable Login user) {
	 * 
	 * System.out.println(user); System.out.println(user.getPassword()); Login
	 * loginUser = userService.login(user.getEmail(), user.getPassword());
	 * 
	 * if (Objects.nonNull(loginUser)) {
	 * 
	 * return "Login Successfully!!";
	 * 
	 * } else { return "Login Failed !!";
	 * 
	 * } }
	 */
}
