package com.citiustech.impact.pms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citiustech.impact.pms.model.EmergencyContactInfo;
import com.citiustech.impact.pms.model.PatientDetails;


public interface EmergencyContactInfoRepository extends JpaRepository<EmergencyContactInfo, Integer>{

	
	
	@Query("from EmergencyContactInfo e left join PatientDetails p on p.mrnNumber = e.patientDetails where p.mrnNumber = ?1")
	public Optional<EmergencyContactInfo> findAllEmergencyContactInfoBymrnNumber(int mrnNumber);
	
}
