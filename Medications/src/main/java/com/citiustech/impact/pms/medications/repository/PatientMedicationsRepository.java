package com.citiustech.impact.pms.medications.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.impact.pms.medications.model.PatientMedications;

@Repository
public interface PatientMedicationsRepository extends JpaRepository<PatientMedications, Integer>{

}
