package com.citiustech.impact.pms.diagnoses.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.impact.pms.diagnoses.model.DiagnosisModel;


public interface DiagnosisRepository extends JpaRepository<DiagnosisModel, Integer>{ 
		
	
		
}
