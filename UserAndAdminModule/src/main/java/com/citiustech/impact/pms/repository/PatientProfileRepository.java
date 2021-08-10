package com.citiustech.impact.pms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citiustech.impact.pms.DTO.PatientDTO;
import com.citiustech.impact.pms.model.PatientProfile;

@Repository
public interface PatientProfileRepository extends JpaRepository<PatientProfile, Long> {

	// @Query("select id, firstName, lastName, dateOfBirth, gender FROM PatientProfile")
	//	List<PatientProfile> findAllPatientDeatils();

}