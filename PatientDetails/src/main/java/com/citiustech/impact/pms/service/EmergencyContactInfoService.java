package com.citiustech.impact.pms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.EmergencyContactInfo;
import com.citiustech.impact.pms.model.Ethinicity;
import com.citiustech.impact.pms.model.PatientDetails;
import com.citiustech.impact.pms.repository.EmergencyContactInfoRepository;
import com.citiustech.impact.pms.repository.PatientDetailsRepository;

@Service
public class EmergencyContactInfoService {

	@Autowired
	EmergencyContactInfoRepository emergencyContactInfoRepo;
	
	@Autowired
	PatientDetailsRepository patientDetailRepo;

	public Optional<EmergencyContactInfo> getPatientEmergecyCntInfo(int id) {

		return emergencyContactInfoRepo.findById(id);
	}

	public EmergencyContactInfo updatePatientEmergencyCntInfo(EmergencyContactInfo patientEmergencyCntInfo) {
		
		
		// pass dynamic MRN Number instead of hardcoded 1
		Optional<PatientDetails> patient = patientDetailRepo.findById(1); 
		
		patientEmergencyCntInfo.setId(1);
		patientEmergencyCntInfo.setFirstName(patientEmergencyCntInfo.getFirstName());
		patientEmergencyCntInfo.setLastName(patientEmergencyCntInfo.getLastName());
		patientEmergencyCntInfo.setHomeAddress(patientEmergencyCntInfo.getHomeAddress());
		patientEmergencyCntInfo.setEmergencyEmail(patientEmergencyCntInfo.getEmergencyEmail());
		patientEmergencyCntInfo.setEmergencyContact(patientEmergencyCntInfo.getEmergencyContact());
		patientEmergencyCntInfo.setPatientPortalAccess(patientEmergencyCntInfo.getPatientPortalAccess());
		patientEmergencyCntInfo.setPatientDetails(patient.get());
		
		
		return emergencyContactInfoRepo.save(patientEmergencyCntInfo);
	}

}
