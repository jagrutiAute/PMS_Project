package com.citiustech.impact.pms.diagnoses.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.diagnoses.model.Diagnoses;
import com.citiustech.impact.pms.diagnoses.repository.DiagnosisRepository;

@Service
public class DiagnosisService {

	@Autowired
	DiagnosisRepository diagnosisRepo;
	
	public Optional<Diagnoses> getDiagnosisDetails(int id) {
		
		return diagnosisRepo.findById(id);
		
	}
}
