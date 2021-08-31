package com.citiustech.impact.pms.controller;

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

import com.citiustech.impact.pms.model.EmergencyContactInfo;
import com.citiustech.impact.pms.model.PatientDetailDTO;
import com.citiustech.impact.pms.model.PatientDetails;
import com.citiustech.impact.pms.service.EmergencyContactInfoService;
import com.citiustech.impact.pms.service.PatientDetailsService;


@RestController
@CrossOrigin(origins = "*")
public class PatientDetailsController {

	static Logger log = Logger.getLogger(PatientDetailsController.class.getName());

	@Autowired
	PatientDetailsService patientDetailsService;

	@Autowired
	EmergencyContactInfoService emergencyContactInfoService;
	
	
	@GetMapping("/getAllPatient")
    public ResponseEntity<List<PatientDetails>> getAllPatient()
    {
		
		List<PatientDetails> patientList=patientDetailsService.fetchAllPatient();
		
		return new ResponseEntity<List<PatientDetails>>(patientList,HttpStatus.OK);
    	
    }

	@GetMapping("/getPatientDetails/{username}")
	public Optional<Optional<PatientDetails>> getPatientDetails(@PathVariable String username) {

		log.debug("inside getPatientDetails() method of PatientDetailsController class");
		log.debug("calling getPatientDetails() method of PatientDetailsService class");
		
		Optional<PatientDetails> patientDetails = patientDetailsService.getPatientDetails(username);

		return Optional.of(patientDetails);
	}
	
	@PostMapping("/updatePatientDetails")
	public ResponseEntity<PatientDetails> updatePatientDetails(@RequestBody PatientDetailDTO patient) {
		
		log.debug("inside updatePatientDetails() method of PatientDetailsController class");
		log.debug("calling updatePatientDetails() method of PatientDetailsService class");
		
		//System.out.println("patient DTO    ::::::  "+patient.toString());
		
		
		PatientDetails updatedpatientDetails = patientDetailsService.updatePatientDetails(patient);
		
		return new ResponseEntity<PatientDetails>(updatedpatientDetails,HttpStatus.OK);
		
	}
	

	@GetMapping("/getPatientEmergencoCntInfo/{id}")
	public Optional<Optional<EmergencyContactInfo>> getEmergencyContactDetails(@PathVariable int id) {

		log.debug("inside getEmergencyContactDetails() method of PatientDetailsController class");
		log.debug("calling getPatientEmergecyCntInfo() method of EmergencyContactInfoService class");
		
		Optional<EmergencyContactInfo> emergencyCntDetails = emergencyContactInfoService.getPatientEmergecyCntInfo(id);

		return Optional.of(emergencyCntDetails);

	}
	
	@PostMapping("/updatePatientEmergencyContactInfo")
	public ResponseEntity<EmergencyContactInfo> updatePatientEmergencyCntDetails(@RequestBody EmergencyContactInfo patientEmergencyCntInfo) {
		
		log.debug("inside updatePatientEmergencyCntDetails() method of PatientDetailsController class");
		log.debug("calling updatePatientEmergencyCntInfo() method of EmergencyContactInfoService class");
		
		EmergencyContactInfo updatedEmergencyInfo = emergencyContactInfoService.updatePatientEmergencyCntInfo(patientEmergencyCntInfo);
		
		return new ResponseEntity<EmergencyContactInfo>(updatedEmergencyInfo,HttpStatus.OK);
		
	}
}
