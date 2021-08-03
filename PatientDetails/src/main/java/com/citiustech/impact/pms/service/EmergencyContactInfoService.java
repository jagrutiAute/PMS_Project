package com.citiustech.impact.pms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.EmergencyContactInfo;

import com.citiustech.impact.pms.repository.EmergencyContactInfoRepository;

@Service
public class EmergencyContactInfoService {

	@Autowired
	EmergencyContactInfoRepository emergencyContactInfoRepo;

	public Optional<EmergencyContactInfo> getPatientEmergecyCntInfo(int id) {

		return emergencyContactInfoRepo.findById(id);
	}

	public EmergencyContactInfo updatePatientEmergencyCntInfo(EmergencyContactInfo patientEmergencyCntInfo) {
		// TODO Auto-generated method stub
		return emergencyContactInfoRepo.save(patientEmergencyCntInfo);
	}

}
