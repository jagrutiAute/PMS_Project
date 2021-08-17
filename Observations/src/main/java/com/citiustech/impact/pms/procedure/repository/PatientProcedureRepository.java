package com.citiustech.impact.pms.procedure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.impact.pms.procedure.model.PatientProcedure;

public interface PatientProcedureRepository extends JpaRepository<PatientProcedure, Integer> {

}
