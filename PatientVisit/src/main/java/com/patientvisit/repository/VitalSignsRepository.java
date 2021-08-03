package com.patientvisit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patientvisit.model.VitalSigns;

public interface VitalSignsRepository extends JpaRepository<VitalSigns, Integer> {

}
