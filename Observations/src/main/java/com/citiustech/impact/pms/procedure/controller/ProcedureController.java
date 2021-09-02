package com.citiustech.impact.pms.procedure.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.procedure.model.PDFGenerator;
import com.citiustech.impact.pms.procedure.model.PatientProcedure;
import com.citiustech.impact.pms.procedure.model.Procedure;
import com.citiustech.impact.pms.procedure.repository.PatientProcedureRepository;
import com.citiustech.impact.pms.procedure.service.ProcedureService;

@RestController
@CrossOrigin(origins = "*")
public class ProcedureController {
	
	static Logger log = Logger.getLogger(ProcedureController.class.getName());

	@Autowired
	ProcedureService procedureService;
	
	@Autowired
	PatientProcedureRepository patientProcedureRepository;
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
    
    @GetMapping("/patient/getAddedProcedure/{pid}/{date}")
	public ResponseEntity<List<PatientProcedure>> getAddedProcedureforspecificdate(@PathVariable String pid,@PathVariable String date){
		LocalDate d=LocalDate.parse(date);
		
		List<PatientProcedure> procedureSave = patientProcedureRepository.findByPidAndDate(pid, d);
		
		return new ResponseEntity<List<PatientProcedure>>(procedureSave, HttpStatus.OK);
	}
    
    @GetMapping(value = "/procedure/download/{pid}/{date}", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> customersReport(@PathVariable String pid,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws IOException {
		List<PatientProcedure> medications = (List<PatientProcedure>) patientProcedureRepository.findByPidAndDate(pid, date);

		System.out.println(medications);

		ByteArrayInputStream bis = PDFGenerator.medicationPDFReport(medications);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=medications.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
}
