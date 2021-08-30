package com.patientvisit.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.patientvisit.controller.VitalSignsController;
import com.patientvisit.dto.VitalSignsDTO;
import com.patientvisit.model.Users;
import com.patientvisit.model.VitalSigns;
import com.patientvisit.repository.UserRepository;
import com.patientvisit.repository.VitalSignsRepository;

@Service
public class VitalSignsServiceImpl implements VitalSignsService {

	static Logger log = Logger.getLogger(VitalSignsServiceImpl.class.getName());

	
	@Autowired 
	private UserRepository userRepo;
	
	@Autowired
	private VitalSignsRepository vitlrepo;
	
	
	@Override
	public VitalSigns updateVitalSigns(VitalSignsDTO vtdto) {
		
		log.debug("inside updateVitalSigns() method of VitalSignsServiceImpl class");
		log.debug("calling findByEmail() method of UserRepository interface");
		
		Users user=userRepo.findByEmail(vtdto.getUserID());
		Users patient=userRepo.findByEmail(vtdto.getPatientID());
		
		VitalSigns vtlsigns=new VitalSigns();
		vtlsigns.setHeight(vtdto.getHeight());
		vtlsigns.setWeight(vtdto.getWeight());
		vtlsigns.setBloodPressure(vtdto.getBloodPressure());
		vtlsigns.setBodyTemperature(vtdto.getBodyTemperature());
		vtlsigns.setRespirationRate(vtdto.getRespirationRate());
		//vtlsigns.setUser(user);
		//vtlsigns.setPatient(patient);
		
		log.debug("calling save() method of VitalSignsRepository interface");
		
		 return vitlrepo.save(vtlsigns);
		 
	
	}

	
	public Optional<VitalSigns> getVitalSigns(String pid) {
		
		 return vitlrepo.findByPatientID(pid);
		 	
	}
}
