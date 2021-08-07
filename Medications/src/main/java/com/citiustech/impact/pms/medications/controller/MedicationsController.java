package com.citiustech.impact.pms.medications.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.medications.dto.MedicationsPatientDTO;
import com.citiustech.impact.pms.medications.model.Medications;
import com.citiustech.impact.pms.medications.model.PatientMedications;
import com.citiustech.impact.pms.medications.service.MedicationsService;

@RestController
public class MedicationsController {
	
	@Autowired
	private MedicationsService medService;

	@PostMapping("/addMedications")
	public ResponseEntity<PatientMedications> getMedications(@RequestBody MedicationsPatientDTO dto)
	{
		ResponseEntity<PatientMedications> patientMed=medService.loadPatientMedications(dto);
		
		return patientMed;
		
	}
	
	@GetMapping("/getMedications/{patientID}")
	public ResponseEntity<PatientMedications> getMedicationsByPatientID()
	{
		ResponseEntity<PatientMedications> patientMed=medService.getPatientMedications();
		
		return patientMed;
		
	}
	
	@GetMapping("/getMedications/{medID}")
	public ResponseEntity<Medications> getMedicationsByMedID(@PathVariable Integer medID)
	{
		Optional<Medications> patientMed=medService.getAllMedications(medID);
		if(!patientMed.isPresent())
		{
			return null;
		}
		return new ResponseEntity<Medications>(patientMed.get(),HttpStatus.OK);
		
	}
}
