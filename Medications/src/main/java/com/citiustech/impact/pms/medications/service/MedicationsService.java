package com.citiustech.impact.pms.medications.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.citiustech.impact.pms.medications.dto.MedicationsPatientDTO;
import com.citiustech.impact.pms.medications.model.Medications;
import com.citiustech.impact.pms.medications.model.PatientMedications;

public interface MedicationsService {

	public ResponseEntity<PatientMedications> loadPatientMedications(MedicationsPatientDTO dto);
 
	public ResponseEntity<PatientMedications> getPatientMedications();
	
	public Optional<Medications> getAllMedications(Integer medID);


}
