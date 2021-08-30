package com.citiustech.impact.pms.allergies.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.allergies.model.Allergy;
import com.citiustech.impact.pms.allergies.model.AllergyDetails;
import com.citiustech.impact.pms.allergies.service.AllergyDetailService;

@RestController
@CrossOrigin(origins = "*")
public class PatientAllergyDetailCoontroller {

	static Logger log = Logger.getLogger(PatientAllergyDetailCoontroller.class.getName());

	
	@Autowired
	AllergyDetailService allergyDetailService;

	
	
	@PostMapping("/savePatientAllergyDetails/{pid}")
	public String addMedicationForPatient(@RequestBody List<Allergy> allergyObject, @PathVariable String pid ) {
		
		System.out.println("pid="+pid);
		
		List<AllergyDetails> allergies = new ArrayList<>();
		
		for(Allergy m: allergyObject) {
			
			AllergyDetails m1 = new AllergyDetails();
			
			//m1.setId(m.getId());
			m1.setName(m.getName());
			m1.setType(m.getType());
			m1.setSource(m.getSource());
			m1.setIsoForms(m.getIsoForms());
			m1.setAllerginiCity(m.getAllerginiCity());
			m1.setPid(pid);
			allergies.add(m1);
		}
		
		allergies.stream().forEach(x->System.out.println(x));
		log.debug("inside getPatientAllergyDetails() method of PatientAllergyDetailCoontroller class");
		log.debug("calling fetchPatientAllergyDetails() method of AllergyDetailService class");
		
		
	//Optional<AllergyDetails> allergyDetails = allergyDetailService.fetchPatientAllergyDetails(pid);
		
		allergyDetailService.addPatientAllergy(allergies);
		return "save";
		
	}
	
	@GetMapping("/getPatientAllergyDetails/{id}")
	public ResponseEntity<List<AllergyDetails>> getPatientAllergyDetails(@PathVariable String id) {

		Optional<List<AllergyDetails>> allergyDetails = allergyDetailService.fetchPatientAllergyDetails(id);

		return new ResponseEntity<List<AllergyDetails>>(allergyDetails.get(), HttpStatus.OK);

	}

	@DeleteMapping("/deletePatientAllergyDetails/{pid}/{id}")
	public void deletePatientAllergyDetails(@PathVariable String pid,@PathVariable Integer id) {

		System.out.println("PID ::: "+pid+" ID :: "+id);
		allergyDetailService.deleteAllergies(pid,id);
		
		

		//return new ResponseEntity<AllergyDetails>(allergyDetails.get(), HttpStatus.OK);

	}
}
