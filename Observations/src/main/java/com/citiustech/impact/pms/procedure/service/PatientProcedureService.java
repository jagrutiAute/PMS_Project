package com.citiustech.impact.pms.procedure.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.citiustech.impact.pms.procedure.controller.ProcedureController;
import com.citiustech.impact.pms.procedure.model.PatientProcedure;
import com.citiustech.impact.pms.procedure.repository.PatientProcedureRepository;

@Service
public class PatientProcedureService {

	static Logger log = Logger.getLogger(PatientProcedureService.class.getName());

	@Autowired
	PatientProcedureRepository patientProcedureRepo;

	public PatientProcedure addPatientProcedure(PatientProcedure patientProcedure) {
		// TODO Auto-generated method stub
		
		log.debug("inside addPatientProcedure() method of PatientProcedureService class");
		log.debug("calling save() method of PatientProcedureRepository interface");
		
		return patientProcedureRepo.save(patientProcedure);
	}

	public Optional<List<PatientProcedure>> fetchPatientProcedure(String pid) {
		
		log.debug("inside fetchPatientProcedure() method of PatientProcedureService class");
		log.debug("calling findById() method of PatientProcedureRepository interface");
		
		
		return patientProcedureRepo.findByPid(pid);
		//return patientProcedureRepo.getAllPatientProcedure(pid);
		
	}

	
	
	public List<PatientProcedure> addPatientProcedure(List<PatientProcedure> procedures) {

		
		return patientProcedureRepo.saveAll(procedures);
		// return allergyDetailsRepo.save(allergyDetails);

	}
	
	
}
