package com.patientvisit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patientvisit.model.VitalSigns;

public interface VitalSignsRepository extends JpaRepository<VitalSigns, Integer> {

	Optional<VitalSigns> findByPatientID(String pid);

}
