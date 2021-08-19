package com.citiustech.impact.pms.medications.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.impact.pms.medications.model.PatientProfile;


@Repository
public interface PatientProfileRepository extends JpaRepository<PatientProfile, Long> {

}