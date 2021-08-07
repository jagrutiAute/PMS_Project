package com.citiustech.impact.pms.procedure.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.procedure.model.PatientProcedure;
import com.citiustech.impact.pms.procedure.repository.PatientProcedureRepository;

@Service
public class PatientProcedureService {

	@Autowired
	PatientProcedureRepository patientProcedureRepo;

	public PatientProcedure addPatientProcedure(PatientProcedure patientProcedure) {
		// TODO Auto-generated method stub
		return patientProcedureRepo.save(patientProcedure);
	}

	public Optional<PatientProcedure> fetchPatientProcedure(Integer id) {
		
		return patientProcedureRepo.findById(id);
		
	}
	
	
}
