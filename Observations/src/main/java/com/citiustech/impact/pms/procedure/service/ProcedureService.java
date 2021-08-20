package com.citiustech.impact.pms.procedure.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.procedure.model.Procedure;
import com.citiustech.impact.pms.procedure.repository.ProcedureRepository;

@Service
public class ProcedureService {

	
	static Logger log = Logger.getLogger(ProcedureService.class.getName());

	@Autowired
	ProcedureRepository procedureRepo;
	
	public Optional<Procedure> getProcedureDetails(int proceCode) {
		
		log.debug("inside getProcedureDetails() method of ProcedureService class");
		log.debug("calling findById() method of ProcedureRepository interface");
		
		return procedureRepo.findById(proceCode);
	}

}
