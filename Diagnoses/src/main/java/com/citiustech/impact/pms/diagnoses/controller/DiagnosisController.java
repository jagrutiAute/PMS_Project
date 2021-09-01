package com.citiustech.impact.pms.diagnoses.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

import com.citiustech.impact.pms.diagnoses.model.DiagnosisModel;
import com.citiustech.impact.pms.diagnoses.model.DiagnosisSave;
import com.citiustech.impact.pms.diagnoses.service.DiagnosisService;




@CrossOrigin(origins = "*")
@RestController
public class DiagnosisController {

	
	@Autowired
	private DiagnosisService diagnosisService;
	
	static Logger log = Logger.getLogger(DiagnosisModel.class.getName());
	
	@GetMapping("physician/diagnosis")
	public ResponseEntity<List<DiagnosisModel>> getAllDiagnosis(){
		System.out.println("inside getMedicationDetails=");
		List<DiagnosisModel> diagnosis = diagnosisService.getDiagnosis();
		
		log.debug("inside getMedicationDetails() method");
		log.debug("calling findAll() method of MedicationRepo interface");
		
		
		return new ResponseEntity<List<DiagnosisModel>>(diagnosis, HttpStatus.OK);
	}
	
	@PostMapping("physician/addDiagnosis/{pid}/{phyid}")
	public String addMedicationForPatient(@RequestBody List<DiagnosisSave> diagnosisObject, @PathVariable String pid, @PathVariable String phyid){
		
		System.out.println("pid="+pid);
		System.out.println("phyid="+phyid);
		List<DiagnosisSave> diagnosisSaveArrayList = new ArrayList<>();
		for(DiagnosisSave d: diagnosisObject) {
			
			DiagnosisSave d1 = new DiagnosisSave();
			
			d1.setDiagnosis_code(d.getDiagnosis_code());
			d1.setDiagnosis_description(d.getDiagnosis_description());
			d1.setDiagnosis_is_deprecated(d.getDiagnosis_is_deprecated());
			d1.setPid(pid);
			d1.setPhyid(phyid);
//		    m1.setApplNo(m.getApplNo());
//		    m1.setProductNo(m.getProductNo());
//		    m1.setForm(m.getForm());
//		    m1.setStrength(m.getStrength());
//		    m1.setReferenceDrug(m.getReferenceDrug());
//		    m1.setDrugName(m.getDrugName());
//		    m1.setActiveIngredient(m.getActiveIngredient());
//		    m1.setReferenceStandard(m.getReferenceStandard());
//		    m1.setPid(pid);
//		    m1.setPhyid(phyid);
//		    m1.setDate(LocalDate.now());
			diagnosisSaveArrayList.add(d1);
//		    medicationSaves.add(m1);
		}
		diagnosisSaveArrayList.stream().forEach(x->System.out.println(x));
		
		//diagnosisObject.add(m1);
		//System.out.println(diagnosisObject);
		//System.out.println();
		//diagnosisObject.stream().forEach(a -> System.out.println(a));
		//List<Medication> medication = medicationRepo.findAllMedication();
		diagnosisService.addDiagnosis(diagnosisSaveArrayList);
		//return new ResponseEntity<List<Medication>>(medication, HttpStatus.OK);
		return "save";
	}
	
	@GetMapping("physician/getAddedDiagnosis/{id}")
	public ResponseEntity<List<DiagnosisSave>> getAddedDiagnosis(@PathVariable String id){
		List<DiagnosisSave> DiagnosisSave = diagnosisService.gettingAddedDiagnosis(id);
		
		return new ResponseEntity<List<DiagnosisSave>>(DiagnosisSave, HttpStatus.OK);
	}
}
