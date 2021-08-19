package com.citiustech.impact.pms.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citiustech.impact.pms.model.Ethinicity;
import com.citiustech.impact.pms.model.PatientDetailDTO;
import com.citiustech.impact.pms.model.PatientDetails;
import com.citiustech.impact.pms.model.Race;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.EthinicityRepository;
import com.citiustech.impact.pms.repository.PatientDetailsRepository;
import com.citiustech.impact.pms.repository.RaceRepository;

@Service
public class PatientDetailsService {

	static Logger log = Logger.getLogger(PatientDetailsService.class.getName());

	@Autowired
	PatientDetailsRepository patientDetailsRepo;

	@Autowired
	EthinicityRepository ethinicityRepo;

	@Autowired
	RaceRepository raceRepo;

	public Optional<PatientDetails> getPatientDetails(String username) {

		log.debug("inside getPatientDetails() method of PatientDetailsService class");
		log.debug("calling findAllPatientDetailsByUsername() method of PatientDetailsRepository interface");
		
	
		//Optional<PatientDetails> patientDetailsSer = patientDetailsRepo.findById(id);
		Optional<PatientDetails> patientDetailsSer = patientDetailsRepo.findAllPatientDetailsByUsername(username);
		
		//System.out.println("patientDetailsSer::::::" + patientDetailsSer);

		return patientDetailsSer;

	}

	public PatientDetails updatePatientDetails(PatientDetailDTO patient) {

		PatientDetails patientDetails = new PatientDetails();

		
		log.debug("inside updatePatientDetails() method of PatientDetailsService class");
		log.debug("calling findById() method of EthinicityRepository interface");
		
		Optional<Ethinicity> ethinicity = ethinicityRepo.findById(patient.getEthinicity());
		Optional<Race> race = raceRepo.findById(patient.getRace());
		
		//System.out.println("ethinicity ::: "+ethinicity.get()+"  race  ::   "+race.get());

		String email =  patient.getEmail();
		
		RestTemplate rest = new RestTemplate();
		Users user = rest.getForObject("http://localhost:8088/getUser/"+email, Users.class);

		//System.out.println("user  :::::  " + user);

		// pass dynamic MRN Number instead of hardcoded 1
		patientDetails.setMrnNumber(patient.getMrnNumber());
		patientDetails.setFirstName(patient.getFirstName());
		patientDetails.setLastName(patient.getLastName());
		patientDetails.setDateOfBirth(patient.getDateOfBirth());
		patientDetails.setAge(patient.getAge());
		patientDetails.setGender(patient.getGender());
		patientDetails.setLanguageKnown(patient.getLanguageKnown());
		patientDetails.setHomeAddress(patient.getHomeAddress());
		
		user.setEmail(patient.getEmail());
		user.setPhoneNumber(patient.getContactNumber());
		patientDetails.setUser(user);
		patientDetails.setEthinicity(ethinicity.get());
		patientDetails.setRace(race.get());

		return patientDetailsRepo.save(patientDetails);
	}

}
