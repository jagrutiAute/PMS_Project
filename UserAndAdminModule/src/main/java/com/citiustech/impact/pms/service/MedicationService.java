package com.citiustech.impact.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.citiustech.impact.pms.model.MedicationSave;
import com.citiustech.impact.pms.repository.MedicationSaveRepository;

@Service
public class MedicationService {

	@Autowired
	private MedicationSaveRepository medicationSaveRepository;
	
	public void addMedication(List<MedicationSave> medicationDTO) {
		// TODO Auto-generated method stub
		// medicationSaveRepository.save(medicationDTO);
		medicationDTO.stream().forEach(a -> System.out.println(a));
		medicationSaveRepository.saveAll(medicationDTO);
	}

	public List<MedicationSave> gettingAddedMedication() {
		return medicationSaveRepository.findAll();
		
		
	}

	
}
