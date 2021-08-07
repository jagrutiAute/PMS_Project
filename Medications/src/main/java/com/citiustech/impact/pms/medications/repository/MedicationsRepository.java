package com.citiustech.impact.pms.medications.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.impact.pms.medications.model.Medications;

@Repository
public interface MedicationsRepository extends JpaRepository<Medications, Integer>{

}
