package com.reports.controlller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reports.dto.AppointemenDetailsDTO;
import com.reports.dto.VisitHistoryDTO;
import com.reports.model.MedicationSave;
import com.reports.repo.VisitHistoryRepo;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/reports-service")
public class PatientVisitHistoryController {

	@Autowired
	VisitHistoryRepo visitdetailsrepo;
			
			@GetMapping("/patient/visit/{patientid}")			
			public List<VisitHistoryDTO> getAllVisitDetails(@PathVariable String patientid){
							System.out.println(patientid);
							List<MedicationSave> resutl=visitdetailsrepo.findByPid(patientid);
							System.out.println(resutl);
							List<VisitHistoryDTO> finalResult=	new ArrayList<>();
							for(MedicationSave medication:resutl) {
								VisitHistoryDTO tmp=new VisitHistoryDTO();
								tmp.setDate(medication.getDate());
								tmp.setPhyId(medication.getPhyid());
								finalResult.add(tmp);
							} 
						return finalResult;	
			}
			
		@GetMapping("/patient/visit/visitdetails/{patientid}/{date}")
		public List<AppointemenDetailsDTO> getVisitDetailsofPatient(@PathVariable String patientid,@PathVariable LocalDate date){
				
			
			
			return null;
		}
			
			
}
