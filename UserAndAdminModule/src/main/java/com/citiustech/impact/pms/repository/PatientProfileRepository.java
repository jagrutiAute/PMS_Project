package com.citiustech.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.impact.pms.model.PatientProfile;

@Repository
public interface PatientProfileRepository extends JpaRepository<PatientProfile, Long> {

}