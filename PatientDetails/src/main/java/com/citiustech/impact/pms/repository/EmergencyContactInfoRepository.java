package com.citiustech.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.impact.pms.model.PatientDetails;

public interface EmergencyContactInfoRepository extends JpaRepository<PatientDetails, Integer>{

}
