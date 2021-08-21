package com.citiustech.impact.pms.diagnoses.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.diagnoses.model.Diagnoses;
import com.citiustech.impact.pms.diagnoses.repository.DiagnosisRepository;

@Service
public class DiagnosisService {

	static Logger log = Logger.getLogger(DiagnosisService.class.getName());

	@Autowired
	DiagnosisRepository diagnosisRepo;
	
	public Optional<Diagnoses> getDiagnosisDetails(int id) {
		
		log.debug("inside getDiagnosisDetails() method of DiagnosisService class");
		log.debug("calling findById() method of DiagnosisRepository interface");
		
		return diagnosisRepo.findById(id);
		
	}
}
