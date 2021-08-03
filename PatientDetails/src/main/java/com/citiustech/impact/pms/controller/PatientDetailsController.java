package com.citiustech.impact.pms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.EmergencyContactInfo;
import com.citiustech.impact.pms.model.PatientDetails;
import com.citiustech.impact.pms.service.EmergencyContactInfoService;
import com.citiustech.impact.pms.service.PatientDetailsService;

@RestController
public class PatientDetailsController {

	@Autowired
	PatientDetailsService patientDetailsService;

	@Autowired
	EmergencyContactInfoService emergencyContactInfoService;

	@GetMapping("/getPatientDetails/{id}")
	public Optional<Optional<PatientDetails>> getPatientDetails(@PathVariable int id) {

		Optional<PatientDetails> patientDetails = patientDetailsService.getPatientDetails(id);

		return Optional.of(patientDetails);
	}
	
	@PutMapping("/updatePatientDetails")
	public ResponseEntity<PatientDetails> updatePatientDetails(@RequestBody PatientDetails patient) {
		
		PatientDetails updatedpatientDetails = patientDetailsService.updatePatientDetails(patient);
		
		return new ResponseEntity<PatientDetails>(updatedpatientDetails,HttpStatus.OK);
		
	}
	

	@GetMapping("/getPatientEmergencoCntInfo/{id}")
	public Optional<Optional<EmergencyContactInfo>> getEmergencyContactDetails(@PathVariable int id) {

		Optional<EmergencyContactInfo> emergencyCntDetails = emergencyContactInfoService.getPatientEmergecyCntInfo(id);

		return Optional.of(emergencyCntDetails);

	}
	
	@PostMapping("/updatePatientEmergencyContactInfo")
	public ResponseEntity<EmergencyContactInfo> updatePatientEmergencyCntDetails(@RequestBody EmergencyContactInfo patientEmergencyCntInfo) {
		
		EmergencyContactInfo updatedEmergencyInfo = emergencyContactInfoService.updatePatientEmergencyCntInfo(patientEmergencyCntInfo);
		
		return new ResponseEntity<EmergencyContactInfo>(updatedEmergencyInfo,HttpStatus.OK);
		
	}
}
