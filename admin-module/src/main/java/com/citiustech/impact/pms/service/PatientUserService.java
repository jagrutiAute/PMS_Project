package com.citiustech.impact.pms.service;

import java.util.List;
import java.util.Optional;

import com.citiustech.impact.pms.model.PatientUser;


public interface PatientUserService {

	List<PatientUser> gettinPatient();

	PatientUser addingCourse(PatientUser patient);

	Optional<PatientUser> gettinPatientById(int id);

	PatientUser updatingPatientById(PatientUser patient);

	void deletePatient(PatientUser patient);

	List<PatientUser> gettingByLastnameOrFirstname(String lastname, String firstname);

	

}
