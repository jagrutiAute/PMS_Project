package com.citiustech.impact.pms.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.citiustech.impact.pms.DTO.MedicationDTO;
import com.citiustech.impact.pms.model.Medication;
import com.citiustech.impact.pms.model.MedicationSave;
//import com.citiustech.impact.pms.model.MedicationSave;
import com.citiustech.impact.pms.repository.MedicationRepo;
import com.citiustech.impact.pms.repository.MedicationSaveRepository;
import com.citiustech.impact.pms.service.MedicationService;
import com.citiustech.impact.pms.util.PDFGenerator;
//import com.citiustech.impact.pms.repository.MedicationSaveRepository;
//import com.citiustech.impact.pms.service.MedicationService;

@CrossOrigin(origins = "*")
@RestController
public class MedicationController {

	static Logger log = Logger.getLogger(MedicationController.class.getName());

	@Autowired
	private MedicationRepo medicationRepo;

	@Autowired
	private MedicationService medicationService;

	@Autowired
	private MedicationSaveRepository medicationSaveRepo;

	@GetMapping("physician/medication")
	public ResponseEntity<List<Medication>> getMedicationDetails() {
		System.out.println("inside getMedicationDetails=");
		List<Medication> medication = medicationRepo.findAllMedication();

		log.debug("inside getMedicationDetails() method");
		log.debug("calling findAll() method of MedicationRepo interface");

		// List<Medication> medication = medicationRepo.findAll();
		return new ResponseEntity<List<Medication>>(medication, HttpStatus.OK);
	}
	
	@PostMapping("physician/addmedication/{pid}")
	public String addMedicationForPatient(@RequestBody List<MedicationSave> medicationObject, @PathVariable String pid){
		
		System.out.println("pid="+pid);
		
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
		    //m1.setPhyid(phyid);
		    m1.setDate(LocalDate.now());
		    medicationSaves.add(m1);
		}
		medicationSaves.stream().forEach(x -> System.out.println(x));

		// medicationObject.add(m1);
		System.out.println(medicationObject);
		System.out.println();
		medicationObject.stream().forEach(a -> System.out.println(a));
		List<Medication> medication = medicationRepo.findAllMedication();
		medicationService.addMedication(medicationSaves);
		// return new ResponseEntity<List<Medication>>(medication, HttpStatus.OK);
		return "save";
	}
	
	@GetMapping("physician/getAddedMedication/{pid}")
	public ResponseEntity<List<MedicationSave>> getAddedMedication(@PathVariable String pid){
		List<MedicationSave> medicationSave = medicationService.gettingAddedMedication(pid);
		
		return new ResponseEntity<List<MedicationSave>>(medicationSave, HttpStatus.OK);
	}

	@GetMapping(value = "/medications/{pid}/{date}", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> customersReport(@PathVariable String pid,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws IOException {
		List<MedicationSave> medications = (List<MedicationSave>) medicationSaveRepo.findByPidAndDate(pid, date);

		System.out.println(medications);

		ByteArrayInputStream bis = PDFGenerator.medicationPDFReport(medications);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=medications.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
}
