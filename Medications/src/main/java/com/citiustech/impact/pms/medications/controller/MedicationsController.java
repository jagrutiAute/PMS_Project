package com.citiustech.impact.pms.medications.controller;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.controller.AccountController;
import com.citiustech.impact.pms.medications.dto.MedicationsPatientDTO;
import com.citiustech.impact.pms.medications.model.Medications;
import com.citiustech.impact.pms.medications.model.PatientMedications;
import com.citiustech.impact.pms.medications.service.MedicationsService;

@RestController
public class MedicationsController {
	
	static Logger log = Logger.getLogger(MedicationsController.class.getName());

	
	@Autowired
	private MedicationsService medService;

	@PostMapping("/addMedications")
	public ResponseEntity<PatientMedications> getMedications(@RequestBody MedicationsPatientDTO dto)
	{
		log.debug("inside getMedications() method of MedicationsController");
		log.debug("calling loadPatientMedications() method of MedicationsService class");
		ResponseEntity<PatientMedications> patientMed=medService.loadPatientMedications(dto);
		
		return patientMed;
		
	}
	
	@GetMapping("/getMedications/{patientID}")
	public ResponseEntity<PatientMedications> getMedicationsByPatientID()
	{
		log.debug("inside getMedicationsByPatientID() method of MedicationsController");
		log.debug("calling getPatientMedications() method of MedicationsService class");
		ResponseEntity<PatientMedications> patientMed=medService.getPatientMedications();
		
		return patientMed;
		
	}
	
	@GetMapping("/getMedications/{medID}")
	public ResponseEntity<Medications> getMedicationsByMedID(@PathVariable Integer medID)
	{
		log.debug("inside getMedicationsByMedID() method of MedicationsController");
		log.debug("calling getAllMedications() method of MedicationsService class");
		Optional<Medications> patientMed=medService.getAllMedications(medID);
		if(!patientMed.isPresent())
		{
			return null;
		}
		return new ResponseEntity<Medications>(patientMed.get(),HttpStatus.OK);
		
	}
}
