
package com.citiustech.impact.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.DTO.PatientDTO;
import com.citiustech.impact.pms.model.PatientProfile;
import com.citiustech.impact.pms.model.ProviderRegistration;
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
	public String savePatient(PatientDTO p) {

		// Clean up database tables
		// userProfileRepository.deleteAllInBatch();
		// userRepository.deleteAllInBatch();

		String pwd = encryption(p.getEmail(), p.getPwd());
		System.out.println(pwd);

		Users user = new Users();
		user.setEmail(p.getEmail());
		user.setPhoneNumber(p.getContact());
		user.setPassword(p.getPwd());

		PatientProfile patientProfile = new PatientProfile();
		patientProfile.setTitle(p.getTitle());
		patientProfile.setFirstName(p.getFname());
		patientProfile.setLastName(p.getLname());
		patientProfile.setDateOfBirth(p.getDob());
		patientProfile.setEthnicity(1);
		patientProfile.setRace(1);
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

	static String encryption(String email, String password) {
		return org.apache.commons.codec.digest.DigestUtils.sha256Hex(email + password);
	}

}
