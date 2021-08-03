package com.patientvisit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.patientvisit.dto.VitalSignsDTO;
import com.patientvisit.model.VitalSigns;
import com.patientvisit.service.VitalSignsService;

@Controller
@CrossOrigin(origins = "*")
public class VitalSignsController {

	@Autowired
	VitalSignsService vitalSignsService;

	@PostMapping("/vitalsigns")
    public ResponseEntity<VitalSigns> addVitalSigns(@RequestBody VitalSignsDTO vitalSingsDTO)
    {
		System.out.println(" vital sings dto " + vitalSingsDTO);
		VitalSigns vtlSigns=vitalSignsService.updateVitalSigns(vitalSingsDTO);
		
		return new ResponseEntity<VitalSigns>(vtlSigns,HttpStatus.CREATED);
    	
    }
	
}
