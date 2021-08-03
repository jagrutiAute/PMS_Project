package com.patientvisit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientvisit.model.PatientProfile;

@Repository
public interface PatientProfileRepository extends JpaRepository<PatientProfile, Long> {

}