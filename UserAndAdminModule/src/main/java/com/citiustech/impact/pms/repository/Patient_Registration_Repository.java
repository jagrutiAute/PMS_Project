package com.citiustech.impact.pms.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.impact.pms.model.Patient_Registration;
import com.citiustech.impact.pms.model.Users;

public interface Patient_Registration_Repository extends JpaRepository<Patient_Registration, Long> {

	
	//registration data to store in db
	//query users+patient_registration =>user and patient table
	//spring data jpa
	
	
   Patient_Registration registration(int id, String title , String firstName, String lastName, Date dateOfBirth );
           Patient_Registration findById(String id);
           Patient_Registration findByTitle(String title);
           Patient_Registration findByFirstName(String firstName);
           Patient_Registration findByLatName(String lastName);
           Patient_Registration findByDateOfBirth(Date dateOfBirth);
}
