package com.citiustech.impact.pms.diagnoses.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.diagnoses.model.DiagnosisModel;
import com.citiustech.impact.pms.diagnoses.service.DiagnosisService;


@CrossOrigin(origins = "*")
@RestController
public class DiagnosisController {

	
	@Autowired
	private DiagnosisService diagnosisService;
	
	static Logger log = Logger.getLogger(DiagnosisModel.class.getName());
	
	@GetMapping("physician/diagnosis")
	public ResponseEntity<List<DiagnosisModel>> getAllDiagnosis(){
		System.out.println("inside getMedicationDetails=");
		List<DiagnosisModel> diagnosis = diagnosisService.getDiagnosis();
		
		log.debug("inside getMedicationDetails() method");
		log.debug("calling findAll() method of MedicationRepo interface");
		
		
		return new ResponseEntity<List<DiagnosisModel>>(diagnosis, HttpStatus.OK);
	}
}
