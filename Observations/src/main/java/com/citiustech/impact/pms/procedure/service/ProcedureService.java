package com.citiustech.impact.pms.procedure.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.procedure.model.Procedure;
import com.citiustech.impact.pms.procedure.repository.ProcedureRepository;

@Service
public class ProcedureService {

	@Autowired
	ProcedureRepository procedureRepo;
	
	public Optional<Procedure> getProcedureDetails(int proceCode) {
		
		return procedureRepo.findById(proceCode);
	}

}
