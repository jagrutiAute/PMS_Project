

package com.citiustech.impact.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.Patient;
import com.citiustech.impact.pms.model.PatientProfile;
import com.citiustech.impact.pms.model.Role;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.PatientProfileRepository;
import com.citiustech.impact.pms.repository.UserRepository;

@Service
public class PatientServiceImpl implements PatientService {

	static String sha256hexstr;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PatientProfileRepository userProfileRepository;

	public String login(String email, String password) {

		String pwd = encryption(email, password);
		System.out.println(pwd);

		Users user = userRepository.findByEmailAndPassword(email, pwd);

		if (user != null) {
			return "success";
		}

		return "Bad credentials";

	}

	

	@Override
	public String addPatient(Patient p) {

		// Clean up database tables
		//userProfileRepository.deleteAllInBatch();
	    //userRepository.deleteAllInBatch();

		String pwd = encryption(p.getEmail(), p.getPwd());
		System.out.println(pwd);

		// Create a User instance
		//Users user = new Users(p.getEmail(), p.getContact(), pwd, 1);

		Users user = new Users();
		user.setEmail(p.getEmail());
		user.setPhoneNumber(p.getContact());
		user.setPassword(p.getPwd());
		


	   PatientProfile patientProfile = new PatientProfile(p.getTitle(), p.getFname(), p.getLname(), p.getDob(), 1, 1);


		//user.setUserProfile(patientProfile);

	   
		//user.setUserProfile(patientProfile);


		// Set parent reference(user) in child entity(userProfile)
		patientProfile.setUser(user);




		  Users user1=userRepository.findByEmail(user.getEmail());
		  if(user1!=null) 
		  {
			  return "user already exist";
		  
		  }
		  else
		  {
			userRepository.save(user);
			return "user register successfully";
			
		  }
  
		 
		
	}

	static String encryption(String email, String password) {
		return org.apache.commons.codec.digest.DigestUtils.sha256Hex(email + password);
	}

}
