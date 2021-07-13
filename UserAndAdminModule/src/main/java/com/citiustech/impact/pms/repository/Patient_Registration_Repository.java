package com.citiustech.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.impact.pms.model.Patient_Registration;

public interface Patient_Registration_Repository extends JpaRepository<Patient_Registration, Long> {

	
	//registration data to store in db
	//query users+patient_registration =>user and patient table
	//spring data jpa
}
