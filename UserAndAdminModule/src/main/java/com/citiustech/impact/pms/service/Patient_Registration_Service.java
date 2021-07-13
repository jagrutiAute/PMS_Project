package com.citiustech.impact.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.repository.Patient_Registration_Repository;

@Service
public class Patient_Registration_Service {

	@Autowired
	private Patient_Registration_Repository repo;
	
	//logic to store registration data in db and impliment sha256 for password
}
