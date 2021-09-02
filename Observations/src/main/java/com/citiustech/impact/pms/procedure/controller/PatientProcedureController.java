package com.citiustech.impact.pms.procedure.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.procedure.model.PatientProcedure;
import com.citiustech.impact.pms.procedure.model.Procedure;
import com.citiustech.impact.pms.procedure.service.PatientProcedureService;

@RestController
@CrossOrigin(origins = "*")
public class PatientProcedureController {

	static Logger log = Logger.getLogger(PatientProcedureController.class.getName());

	
	@Autowired
	PatientProcedureService patientProcedureService;

	/*
	 * @PostMapping("/savePatientProcedure") public ResponseEntity<PatientProcedure>
	 * savePatientProcedure(@RequestBody PatientProcedure patientProcedure) {
	 * 
	 * log.
	 * debug("inside savePatientProcedure() method of PatientProcedureController class"
	 * ); log.
	 * debug("calling addPatientProcedure() method of PatientProcedureService class"
	 * );
	 * 
	 * PatientProcedure procPatient =
	 * patientProcedureService.addPatientProcedure(patientProcedure);
	 * 
	 * return new ResponseEntity<PatientProcedure>(procPatient, HttpStatus.OK);
	 * 
	 * }
	 */
	
	
	@PostMapping("/savePatientProcedure/{pid}")
	public String addProcedureForPatient(@RequestBody List<Procedure> procedureObject, @PathVariable String pid ) {
		
		System.out.println("pid="+pid);
		
		List<PatientProcedure> procedures = new ArrayList<>();
		
		for(Procedure m: procedureObject) {
			
			PatientProcedure m1 = new PatientProcedure();
			
			m1.setId(m.getId());
			m1.setPid(pid);
			m1.setProcedureCode(m.getProcedureCode());
			m1.setProcedureDesc(m.getProcedureDesc());
			m1.setIsProcedureDpricated(m.getIsProcedureDpricated());
			m1.setDate(LocalDate.now());
			procedures.add(m1);
		}
		
		procedures.stream().forEach(x->System.out.println(x));
		log.debug("inside getPatientAllergyDetails() method of PatientAllergyDetailCoontroller class");
		log.debug("calling fetchPatientAllergyDetails() method of AllergyDetailService class");
		
		
	//Optional<AllergyDetails> allergyDetails = allergyDetailService.fetchPatientAllergyDetails(pid);
		
		patientProcedureService.addPatientProcedure(procedures);
		return "save";
		
	}
	
	@GetMapping("/getPatientProcedure/{id}")
	public ResponseEntity<List<PatientProcedure>> getPatientProcedure(@PathVariable String id) {
		
		log.debug("inside getPatientProcedure() method of PatientProcedureController class");
		log.debug("calling fetchPatientProcedure() method of PatientProcedureService class");
		
		Optional<List<PatientProcedure>> patientProcedure =	patientProcedureService.fetchPatientProcedure(id);
		
		return new ResponseEntity<List<PatientProcedure>>(patientProcedure.get() , HttpStatus.OK);
		
	}
}
