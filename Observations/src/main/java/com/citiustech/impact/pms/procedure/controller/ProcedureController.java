package com.citiustech.impact.pms.procedure.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.procedure.model.Procedure;
import com.citiustech.impact.pms.procedure.service.ProcedureService;

@RestController
@CrossOrigin(origins = "*")
public class ProcedureController {
	
	@Autowired
	ProcedureService procedureService;
	
	
    @GetMapping("/getProcedureDetails/{proceCode}")
	public ResponseEntity<Procedure> getProcedureDetails(@PathVariable int proceCode) {
		
    	Optional<Procedure> procedure = procedureService.getProcedureDetails(proceCode);
    	
		return new ResponseEntity<Procedure>(procedure.get(),HttpStatus.OK);
		
	}
}
