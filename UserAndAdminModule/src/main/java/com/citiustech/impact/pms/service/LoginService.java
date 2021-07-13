package com.citiustech.impact.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.LoginRepository;

/*
 * 
 * Created service class to validate the valid user.
 * Validate the user password using SHA256.
 * Added 'commons-codec' jar(SHA256)
 * 
*/

@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;

	public String login(String email, String password) {

		String sha256hexstr = org.apache.commons.codec.digest.DigestUtils.sha256Hex(email + password);

		Users user = repo.findByEmailAndPassword(email, sha256hexstr);

		if (user != null) {
			return "success";
		}

		return "Bad credentials";

	}

}