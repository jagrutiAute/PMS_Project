package com.patientvisit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.patientvisit.dto.VitalSignsDTO;
import com.patientvisit.model.Users;
import com.patientvisit.model.VitalSigns;
import com.patientvisit.repository.UserRepository;
import com.patientvisit.repository.VitalSignsRepository;

@Service
public class VitalSignsServiceImpl implements VitalSignsService {

	@Autowired 
	private UserRepository userRepo;
	
	@Autowired
	private VitalSignsRepository vitlrepo;
	
	
	@Override
	public VitalSigns updateVitalSigns(VitalSignsDTO vtdto) {
		
		Users user=userRepo.findByEmail(vtdto.getUserID());
		Users patient=userRepo.findByEmail(vtdto.getPatientID());
		
		VitalSigns vtlsigns=new VitalSigns();
		vtlsigns.setHeight(vtdto.getHeight());
		vtlsigns.setWeight(vtdto.getWeight());
		vtlsigns.setBloodPressure(vtdto.getBloodPressure());
		vtlsigns.setBodyTemperature(vtdto.getBodyTemperature());
		vtlsigns.setRespirationRate(vtdto.getRespirationRate());
		vtlsigns.setUser(user);
		vtlsigns.setPatient(patient);
		
		 return vitlrepo.save(vtlsigns);
		 
	
	}

}
