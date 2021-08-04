package com.citiustech.impact.pms.service;

import java.util.Optional;

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

	@Autowired
	PatientDetailsRepository patientDetailsRepo;

	@Autowired
	EthinicityRepository ethinicityRepo;

	@Autowired
	RaceRepository raceRepo;

	public Optional<PatientDetails> getPatientDetails(int id) {

		Optional<PatientDetails> patientDetailsSer = patientDetailsRepo.findById(id);

		System.out.println("patientDetailsSer::::::" + patientDetailsSer);

		return patientDetailsSer;

	}

	public PatientDetails updatePatientDetails(PatientDetailDTO patient) {

		PatientDetails patientDetails = new PatientDetails();

		
		
		Optional<Ethinicity> ethinicity = ethinicityRepo.findById(patient.getEthinicity());
		Optional<Race> race = raceRepo.findById(patient.getRace());
		
		System.out.println("ethinicity ::: "+ethinicity.get()+"  race  ::   "+race.get());

		RestTemplate rest = new RestTemplate();
		Users user = rest.getForObject("http://localhost:8088/getUser/shivraj@gmail.com", Users.class);

		System.out.println("user  :::::  " + user);

		
		patientDetails.setMrnNumber(1);
		patientDetails.setFirstName(patient.getFirstName());
		patientDetails.setLastName(patient.getLastName());
		patientDetails.setDateOfBirth(patient.getDateOfBirth());
		patientDetails.setAge(patient.getAge());
		patientDetails.setGender(patient.getGender());
		patientDetails.setLanguageKnown(patient.getLanguageKnown());
		patientDetails.setHomeAddress(patient.getHomeAddress());
		patientDetails.setUser(user);
		patientDetails.setEthinicity(ethinicity.get());
		patientDetails.setRace(race.get());

		return patientDetailsRepo.save(patientDetails);
	}

}
