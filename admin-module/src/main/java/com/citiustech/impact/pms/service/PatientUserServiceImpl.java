package com.citiustech.impact.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.PatientUser;
import com.citiustech.impact.pms.repository.PatientUserRepository;



@Service
public class PatientUserServiceImpl implements PatientUserService {

	
	@Autowired
	private PatientUserRepository patientUserRepository;
	
	@Override
	public List<PatientUser> gettinPatient() {
		
		return patientUserRepository.findAll();
	}
	/*
	@Override
	public Optional<PatientUser> gettinPatientById(int id) {
		
		return patientUserRepository.findById(id);
	}
	
	@Override
	public PatientUser addingCourse(PatientUser patient) {
		
		patientUserRepository.save(patient);
		return patient;
	}

	@Override
	public PatientUser updatingPatientById(PatientUser patient) {
		
		return patientUserRepository.save(patient);
	}

	@Override
	public void  deletePatient(PatientUser patient) {
		
		 //myRepository.deleteById(id);
		patientUserRepository.delete(patient);
	}

	@Override
	public List<PatientUser> gettingByLastnameOrFirstname(String lastname, String firstname) {
		
		return patientUserRepository.findByLastnameOrFirstname(lastname, firstname);
		
	}

	*/

	

	

}
