package com.citiustech.impact.pms.diagnoses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.impact.pms.diagnoses.model.PatientDiagnosis;

public interface PatientDianosisRepository extends JpaRepository<PatientDiagnosis, Integer> {

}
