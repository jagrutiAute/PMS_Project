package com.citiustech.impact.pms.service;

import org.apache.log4j.Logger;
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

	static Logger log = Logger.getLogger(HospitalUserService.class.getName());

	@Autowired
	private UserRepository repo;

	public Users login(String email,String pwd) {

		//String sha256hexstr = org.apache.commons.codec.digest.DigestUtils.sha256Hex(email + pwd);
		log.debug("inside login() method of LoginService class");


		//Users user = repo.findByEmailAndPassword(email,pwd);
		log.debug("calling findByEmail() method of UserRepository interface");
		Users user =repo.findByEmail(email);
		//System.out.println("status is "+user.getPassword().equals(pwd));
			
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