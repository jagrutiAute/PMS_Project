package com.citiustech.impact.pms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citiustech.impact.pms.model.PatientDetails;

public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Integer> {

@Query("from PatientDetails as p  left join  Users as u on u.id = p.user where u.email = ?1")


public Optional<PatientDetails> findAllPatientDetailsByUsername(String email);



@Query(value="select mrn,first_name,last_name from patient;",nativeQuery = true )
public List<PatientDetails> findPatientInfo();


}
