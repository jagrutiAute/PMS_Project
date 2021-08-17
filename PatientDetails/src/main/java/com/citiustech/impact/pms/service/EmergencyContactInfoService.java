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

	public Optional<EmergencyContactInfo> getPatientEmergecyCntInfo(int mrnNumber) {

		//return emergencyContactInfoRepo.findById(id);
		return emergencyContactInfoRepo.findAllEmergencyContactInfoBymrnNumber(mrnNumber);
	}

	public EmergencyContactInfo updatePatientEmergencyCntInfo(EmergencyContactInfo patientEmergencyCntInfo) {
		
		
		EmergencyContactInfo emergenctContactInfo = new EmergencyContactInfo();
		
		emergenctContactInfo.setId(patientEmergencyCntInfo.getId());
		emergenctContactInfo.setFirstName(patientEmergencyCntInfo.getFirstName());
		emergenctContactInfo.setLastName(patientEmergencyCntInfo.getLastName());
		emergenctContactInfo.setHomeAddress(patientEmergencyCntInfo.getHomeAddress());
		emergenctContactInfo.setEmergencyEmail(patientEmergencyCntInfo.getEmergencyEmail());
		emergenctContactInfo.setEmergencyContact(patientEmergencyCntInfo.getEmergencyContact());
		emergenctContactInfo.setPatientPortalAccess(patientEmergencyCntInfo.getPatientPortalAccess());
		emergenctContactInfo.setPatientDetails(patientEmergencyCntInfo.getPatientDetails());
		
		
		return emergencyContactInfoRepo.save(emergenctContactInfo);
	}

}
