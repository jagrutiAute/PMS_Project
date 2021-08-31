package com.patientvisit.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.patientvisit.dto.VitalSignsDTO;
import com.patientvisit.model.PatientProfile;
import com.patientvisit.model.VitalSigns;
import com.patientvisit.service.VitalSignsService;

@Controller
@CrossOrigin(origins = "*")
public class VitalSignsController {

	static Logger log = Logger.getLogger(VitalSignsController.class.getName());

	@Autowired
	VitalSignsService vitalSignsService;

	@PostMapping("/vitalsigns")
    public ResponseEntity<VitalSigns> addVitalSigns(@RequestBody VitalSignsDTO vitalSingsDTO)
    {
		//System.out.println(" vital sings dto " + vitalSingsDTO);
		log.debug("inside addVitalSigns() method of VitalSignsController class");
		log.debug("calling updateVitalSigns() method of VitalSignsService class");
		
		VitalSigns vtlSigns=vitalSignsService.updateVitalSigns(vitalSingsDTO);
		
		return new ResponseEntity<VitalSigns>(vtlSigns,HttpStatus.CREATED);
    	
    }
	
	@GetMapping("/getvitalsigns/{pid}")
    public ResponseEntity<VitalSigns> fetchVitalSigns(@PathVariable String pid)
    {
		
		Optional<VitalSigns> vtlSigns=(Optional<VitalSigns>) vitalSignsService.getVitalSigns(pid);
		
		return new ResponseEntity<VitalSigns>(vtlSigns.get(),HttpStatus.OK);
    	
    }
	
	
	
}
