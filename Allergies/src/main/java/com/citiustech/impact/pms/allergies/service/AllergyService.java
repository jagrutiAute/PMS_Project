package com.citiustech.impact.pms.allergies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.allergies.model.Allergy;
import com.citiustech.impact.pms.allergies.repository.AllergyRepository;

@Service
public class AllergyService {
	
	@Autowired
	AllergyRepository allergyDetailsRepo;

	public Optional<Allergy> getAllergyDetails(int id) {
		
		
		return allergyDetailsRepo.findById(id);
		
	}

	public Optional<List<Allergy>> getAllergyList() {
		// TODO Auto-generated method stub
		return Optional.of(allergyDetailsRepo.findAll());
	}

}
