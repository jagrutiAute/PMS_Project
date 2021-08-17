package com.citiustech.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.impact.pms.model.Medication;


public interface MedicationRepo extends JpaRepository<Medication, String>{

}
