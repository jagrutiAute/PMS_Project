package com.citiustech.impact.pms.diagnoses.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.diagnoses.controller.DiagnosisController;
import com.citiustech.impact.pms.diagnoses.model.PatientDiagnosis;
import com.citiustech.impact.pms.diagnoses.repository.PatientDianosisRepository;

@Service
public class PatientDiagnosisService {

	static Logger log = Logger.getLogger(PatientDiagnosisService.class.getName());

	@Autowired
	PatientDianosisRepository patientDiagnosisRepo;

	public PatientDiagnosis addPatientDiagnosis(PatientDiagnosis patientDiagnosis) {
		log.debug("inside addPatientDiagnosis() method of PatientDiagnosisService class");
		log.debug("calling save() method of PatientDianosisRepository interface");
		
		return patientDiagnosisRepo.save(patientDiagnosis);
	}

	public Optional<PatientDiagnosis> fetchPaientDiagnosis(Integer id) {
		
		//System.out.println("patientDiagnosisRepo.findById(id) :::::   "+patientDiagnosisRepo.findById(id));
		log.debug("inside fetchPaientDiagnosis() method of PatientDiagnosisService class");
		log.debug("calling findById() method of PatientDianosisRepository interface");
		
		return patientDiagnosisRepo.findById(id);
				
	}
	
	
}
