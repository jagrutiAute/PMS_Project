package com.citiustech.impact.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.LoginRepository;
import com.citiustech.impact.pms.repository.UserRepository;

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
	private UserRepository repo;

	public Users login(String email) {

		//String sha256hexstr = org.apache.commons.codec.digest.DigestUtils.sha256Hex(email + password);

		Users user = repo.findByEmail(email);
		
		System.out.println("user ---------> "+user);
		
		
		
			return user;
		//}
		
		


	}

	public Users updatefaildeLogin(Users loginResult) {
		// TODO Auto-generated method stub
		Users user=repo.save(loginResult);
		return user;
	}
	
	public Users blockUser(Users  user) {
		
			return repo.save(user);
	}
	

}