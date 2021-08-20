package com.citiustech.impact.pms.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.DTO.MedicationDTO;
import com.citiustech.impact.pms.model.Medication;
import com.citiustech.impact.pms.model.MedicationSave;
import com.citiustech.impact.pms.repository.MedicationRepo;
import com.citiustech.impact.pms.repository.MedicationSaveRepository;
import com.citiustech.impact.pms.service.MedicationService;

@CrossOrigin(origins = "*")
@RestController
public class MedicationController {

	@Autowired
	private MedicationRepo medicationRepo;
	
	@Autowired
	private MedicationService medicationService;
	
	@GetMapping("physician/medication")
	public ResponseEntity<List<Medication>> getMedicationDetails(){
		System.out.println("inside getMedicationDetails=");
		List<Medication> medication = medicationRepo.findAllMedication();
		return new ResponseEntity<List<Medication>>(medication, HttpStatus.OK);
	}
	
	@PostMapping("physician/addmedication/{pid}/{phyid}")
	public String addMedicationForPatient(@RequestBody List<MedicationSave> medicationObject, @PathVariable String pid, @PathVariable String phyid){
		
		System.out.println("pid="+pid);
		System.out.println("phyid="+phyid);
		List<MedicationSave> medicationSaves = new ArrayList<>();
		for(MedicationSave m: medicationObject) {
			
		    MedicationSave m1 = new MedicationSave();
		    m1.setApplNo(m.getApplNo());
		    m1.setProductNo(m.getProductNo());
		    m1.setForm(m.getForm());
		    m1.setStrength(m.getStrength());
		    m1.setReferenceDrug(m.getReferenceDrug());
		    m1.setDrugName(m.getDrugName());
		    m1.setActiveIngredient(m.getActiveIngredient());
		    m1.setReferenceStandard(m.getReferenceStandard());
		    m1.setPid(pid);
		    m1.setPhyid(phyid);
		    m1.setDate(LocalDate.now());
		    medicationSaves.add(m1);
		}
		medicationSaves.stream().forEach(x->System.out.println(x));
		
		//medicationObject.add(m1);
		//System.out.println(medicationObject);
		//System.out.println();
		//medicationObject.stream().forEach(a -> System.out.println(a));
		//List<Medication> medication = medicationRepo.findAllMedication();
	    medicationService.addMedication(medicationSaves);
		//return new ResponseEntity<List<Medication>>(medication, HttpStatus.OK);
		return "save";
	}
	
	@GetMapping("physician/getAddedMedication")
	public ResponseEntity<List<MedicationSave>> getAddedMedication(){
		List<MedicationSave> medicationSave = medicationService.gettingAddedMedication();
		
		return new ResponseEntity<List<MedicationSave>>(medicationSave, HttpStatus.OK);
	}
}
