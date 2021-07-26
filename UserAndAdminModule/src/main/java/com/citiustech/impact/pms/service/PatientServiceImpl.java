<<<<<<< HEAD
package com.citiustech.impact.pms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.Patient;
import com.citiustech.impact.pms.model.PatientProfile;
<<<<<<< HEAD
<<<<<<< HEAD
import com.citiustech.impact.pms.model.Users;
=======
import com.citiustech.impact.pms.model.User;
>>>>>>> b707ea0bb99d2dafbba5d70514928c2fbc430850
=======
import com.citiustech.impact.pms.model.User;
>>>>>>> ebdf04721f462af1cc6faab3a2c978d371240229
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

<<<<<<< HEAD
<<<<<<< HEAD
		Users user = userRepository.findByEmailAndPassword(email, pwd);
=======
		User user = userRepository.findByEmailIDAndPassword(email, pwd);
>>>>>>> b707ea0bb99d2dafbba5d70514928c2fbc430850
=======
		User user = userRepository.findByEmailIDAndPassword(email, pwd);
>>>>>>> ebdf04721f462af1cc6faab3a2c978d371240229

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
<<<<<<< HEAD
<<<<<<< HEAD
=======
		User user = new User(p.getEmail(), p.getContact(), pwd, 1);

		// Create a UserProfile instance
	   PatientProfile patientProfile = new PatientProfile(p.getTitle(), p.getFname(), p.getLname(), p.getDob(), 1, 1);

		// Set child reference(userProfile) in parent entity(user)
		user.setUserProfile(patientProfile);

		// Set parent reference(user) in child entity(userProfile)
		patientProfile.setUser(user);


		  Optional<User> user1=userRepository.findByEmailID(user.getEmailID());
		  if(user1.isPresent()) 
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
||||||| 78dff94
=======
package com.citiustech.impact.pms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.Patient;
import com.citiustech.impact.pms.model.PatientProfile;
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
>>>>>>> ebdf04721f462af1cc6faab3a2c978d371240229
		//Users user = new Users(p.getEmail(), p.getContact(), pwd, 1);

		Users user = new Users();
		user.setEmail(p.getEmail());
		user.setPhoneNumber(p.getContact());
		user.setPassword(p.getPwd());
		
<<<<<<< HEAD
=======
		User user = new User(p.getEmail(), p.getContact(), pwd, 1);

>>>>>>> b707ea0bb99d2dafbba5d70514928c2fbc430850
=======
>>>>>>> ebdf04721f462af1cc6faab3a2c978d371240229
		// Create a UserProfile instance
	   PatientProfile patientProfile = new PatientProfile(p.getTitle(), p.getFname(), p.getLname(), p.getDob(), 1, 1);

		// Set child reference(userProfile) in parent entity(user)
<<<<<<< HEAD
<<<<<<< HEAD
		//user.setUserProfile(patientProfile);

	   
=======
		user.setUserProfile(patientProfile);

>>>>>>> b707ea0bb99d2dafbba5d70514928c2fbc430850
=======
		//user.setUserProfile(patientProfile);

	   
>>>>>>> ebdf04721f462af1cc6faab3a2c978d371240229
		// Set parent reference(user) in child entity(userProfile)
		patientProfile.setUser(user);


<<<<<<< HEAD
<<<<<<< HEAD
		  Users user1=userRepository.findByEmail(user.getEmail());
		  if(user1!=null) 
=======
		  Optional<User> user1=userRepository.findByEmailID(user.getEmailID());
		  if(user1.isPresent()) 
>>>>>>> b707ea0bb99d2dafbba5d70514928c2fbc430850
=======
		  Users user1=userRepository.findByEmail(user.getEmail());
		  if(user1!=null) 
>>>>>>> ebdf04721f462af1cc6faab3a2c978d371240229
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
>>>>>>> 8c23b399729fd76973e53460bbd8c7cc648c8d6f
