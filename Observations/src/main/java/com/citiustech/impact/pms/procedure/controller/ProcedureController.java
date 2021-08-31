package com.citiustech.impact.pms.procedure.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
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
	
	static Logger log = Logger.getLogger(ProcedureController.class.getName());

	@Autowired
	ProcedureService procedureService;
	
	
	/*
	 * @GetMapping("/getProcedureDetails/{proceCode}") public
	 * ResponseEntity<Procedure> getProcedureDetails(@PathVariable int proceCode) {
	 * 
	 * log.debug("inside getProcedureDetails() method of ProcedureController class"
	 * );
	 * log.debug("calling getProcedureDetails() method of ProcedureService class");
	 * 
	 * Optional<Procedure> procedure =
	 * procedureService.getProcedureDetails(proceCode);
	 * 
	 * return new ResponseEntity<Procedure>(procedure.get(),HttpStatus.OK);
	 * 
	 * }
	 */
    
    @GetMapping("/getProcedureDetails")
	public ResponseEntity<List<Procedure>> getprocedureDetailsList(){
		
		Optional< List<Procedure>> procedure =  procedureService.getprocedureList();
	
		return new ResponseEntity<List<Procedure>>(procedure.get(),HttpStatus.OK);
		
	}
}
