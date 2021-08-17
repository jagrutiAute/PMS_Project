package com.citiustech.impact.pms.diagnoses.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.diagnoses.model.PatientDiagnosis;
import com.citiustech.impact.pms.diagnoses.repository.PatientDianosisRepository;

@Service
public class PatientDiagnosisService {

	@Autowired
	PatientDianosisRepository patientDiagnosisRepo;

	public PatientDiagnosis addPatientDiagnosis(PatientDiagnosis patientDiagnosis) {
		// TODO Auto-generated method stub
		return patientDiagnosisRepo.save(patientDiagnosis);
	}

	public Optional<PatientDiagnosis> fetchPaientDiagnosis(Integer id) {
		
		System.out.println("patientDiagnosisRepo.findById(id) :::::   "+patientDiagnosisRepo.findById(id));
		return patientDiagnosisRepo.findById(id);
				
	}
	
	
}
