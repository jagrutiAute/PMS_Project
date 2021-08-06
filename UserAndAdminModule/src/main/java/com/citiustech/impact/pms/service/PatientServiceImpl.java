
package com.citiustech.impact.pms.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.DTO.PatientDTO;
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
	public String savePatient(PatientDTO p) {

		
		String pwd = encryption(p.getEmail(), p.getPwd());
		System.out.println(pwd);

		Users user = new Users();
		user.setEmail(p.getEmail());
		user.setPhoneNumber(p.getContact());
		user.setPassword(pwd);

		PatientProfile patientProfile = new PatientProfile();
		patientProfile.setTitle(p.getTitle());
		patientProfile.setFirstName(p.getFname());
		patientProfile.setLastName(p.getLname());
		patientProfile.setDateOfBirth(p.getDob());
		patientProfile.setRace(1);
		patientProfile.setEthnicity(1);
		
		if(p.getTitle().equals("MS") || p.getTitle().equals("MRS"))
			patientProfile.setGender("Female");
		else patientProfile.setGender("Male");
		
		 //create calendar object for birth day
		Calendar birthDay = p.getDob();
		
		//create calendar object for current day
	      long currentTime = System.currentTimeMillis();
	      Calendar now = Calendar.getInstance();
	      now.setTimeInMillis(currentTime);
	 
	      //Get difference between years
	     int years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
	     
	     patientProfile.setAge(years);
	     
	     patientProfile.setUser(user);

		// user.setUserProfile(patientProfile);

		Users user1 = userRepository.findByEmail(user.getEmail());
		if (user1 != null) {
			return "user already exist";

		} else {
			userProfileRepository.save(patientProfile);
			return "user register successfully";

		}

	}

	public static String encryption(String email, String password) {
		return org.apache.commons.codec.digest.DigestUtils.sha256Hex(email + password);
	}

}
