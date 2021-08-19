package com.citiustech.impact.pms.diagnoses.controller;

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

import com.citiustech.impact.pms.diagnoses.model.PatientDiagnosis;
import com.citiustech.impact.pms.diagnoses.service.PatientDiagnosisService;

@RestController
@CrossOrigin(origins = "*")
public class PatientDiagnosisController {

	static Logger log = Logger.getLogger(PatientDiagnosisController.class.getName());

	@Autowired
	PatientDiagnosisService patientDiagnosisService;

	@PostMapping("/savePatientDiagnosis")
	public ResponseEntity<PatientDiagnosis> savePatientDiagnosis(@RequestBody PatientDiagnosis patientDiagnosis) {

		log.debug("inside savePatientDiagnosis() method of PatientDiagnosisController class");
		log.debug("calling addPatientDiagnosis() method of PatientDiagnosisService class");
		
		PatientDiagnosis patientDiagnos = patientDiagnosisService.addPatientDiagnosis(patientDiagnosis);

		return new ResponseEntity<PatientDiagnosis>(patientDiagnos, HttpStatus.OK);

	}

	@GetMapping("/getPatientDiagnosis/{id}")
	public ResponseEntity<PatientDiagnosis> getPatientDiagnosis(@PathVariable Integer id) {

		log.debug("inside savePatientDiagnosis() method of PatientDiagnosisController class");
		log.debug("calling fetchPaientDiagnosis() method of PatientDiagnosisService class");
		
		Optional<PatientDiagnosis> patientDiagnosis = patientDiagnosisService.fetchPaientDiagnosis(id);

		return new ResponseEntity<PatientDiagnosis>(patientDiagnosis.get(), HttpStatus.OK);

	}
}
