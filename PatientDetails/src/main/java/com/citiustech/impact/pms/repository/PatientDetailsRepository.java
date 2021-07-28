package com.citiustech.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.impact.pms.model.PatientDetails;

public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Integer> {

}
