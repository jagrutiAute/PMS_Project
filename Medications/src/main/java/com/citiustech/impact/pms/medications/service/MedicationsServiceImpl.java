package com.citiustech.impact.pms.medications.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.medications.dto.MedicationsPatientDTO;
import com.citiustech.impact.pms.medications.model.Medications;
import com.citiustech.impact.pms.medications.model.PatientMedications;
import com.citiustech.impact.pms.medications.model.Users;
import com.citiustech.impact.pms.medications.repository.MedicationsRepository;
import com.citiustech.impact.pms.medications.repository.PatientMedicationsRepository;
import com.citiustech.impact.pms.medications.repository.UserRepository;

@Service
public class MedicationsServiceImpl implements MedicationsService{

	@Autowired
	PatientMedicationsRepository patientMedRepo;
	
	@Autowired
	MedicationsRepository medRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public ResponseEntity<PatientMedications> getPatientMedications() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Optional<Medications> getAllMedications(Integer medID) 
	{
	//	Optional<Medications> med=medRepo.findById(medID);
		
		return null;
	}

	@Override
	public ResponseEntity<PatientMedications> loadPatientMedications(MedicationsPatientDTO dto) {

		
		Users user=userRepo.findByEmail(dto.getPid());
		Users patient=userRepo.findByEmail(dto.getPhid());
		List<Medications> mlist=dto.getMedications();
		List<PatientMedications> pmedlist=new ArrayList<>();
		
		for(Medications m:mlist)
		{
			PatientMedications pmed=new PatientMedications();
			pmed.setPatientID(user);
			pmed.setPhysicanID(patient);
			//pmed.setMedications(m);
			pmedlist.add(pmed);
		}
		
		
		patientMedRepo.saveAll(pmedlist);
		
		
	
		return null;
	}




}
