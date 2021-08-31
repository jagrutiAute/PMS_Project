package com.patientvisit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.patientvisit.model.PatientProfile;

@Repository
public interface PatientProfileRepository extends JpaRepository<PatientProfile, Long> {

	//@Query(value="id,firstName,lastName from PatientProfile")
    //Optional<List<PatientProfile>> findAllId();
}