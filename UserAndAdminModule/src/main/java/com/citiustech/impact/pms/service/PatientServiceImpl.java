
package com.citiustech.impact.pms.service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.DTO.PatientDTO;
import com.citiustech.impact.pms.model.ISActive;
import com.citiustech.impact.pms.model.PatientProfile;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.PatientProfileRepository;
import com.citiustech.impact.pms.repository.UserRepository;

@Service
public class PatientServiceImpl implements PatientService {

	static String sha256hexstr;

	private LocalDate Date;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PatientProfileRepository patientProfileRepository;

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
		user.setIsActive(ISActive.ACTIVE);


		PatientProfile patientProfile = new PatientProfile();
		patientProfile.setTitle(p.getTitle());
		patientProfile.setFirstName(p.getFname());
		patientProfile.setLastName(p.getLname());
		patientProfile.setDateOfBirth(p.getDob());
		patientProfile.setRace(1);
		patientProfile.setEthnicity(1);



		
		
		
		if(p.getTitle().equals("MS") || p.getTitle().equals("MRS"))

			patientProfile.setGender("Female");
		else
			patientProfile.setGender("Male");

		// create calendar object for birth day
		Calendar birthDay = p.getDob();

		// create calendar object for current day
		long currentTime = System.currentTimeMillis();
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(currentTime);

		// Get difference between years
		int years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);

		patientProfile.setAge(years);

		patientProfile.setUser(user);

		// user.setUserProfile(patientProfile);

		Users user1 = userRepository.findByEmail(user.getEmail());
		if (user1 != null) {
			return "user already exist";

		} else {
			userProfileRepository.save(patientProfile);
			System.out.println("patientProfilr"+patientProfile);
			return "user register successfully";

		}

	}

	public static String encryption(String email, String password) {
		return org.apache.commons.codec.digest.DigestUtils.sha256Hex(email + password);
	}

	@Override
	public List<PatientProfile> gettingUserDetails() {

		return patientProfileRepository.findAll();
	}

	@Override
	public Users updatingStatus(int id, String status) {

		
	Users users = userRepository.findById((long) id).get();	
	System.out.println("113="+users);
	users.setIsActive(ISActive.valueOf(status));
	System.out.println("115="+users);

		return userRepository.save(users);
	}

	@Override
	public Optional<PatientProfile> gettinPatientById(int id) {

		return patientProfileRepository.findById((long) id);
	}

}
