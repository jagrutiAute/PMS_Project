package com.citiustech.impact.pms.procedure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.impact.pms.procedure.model.Procedure;

public interface ProcedureRepository extends JpaRepository<Procedure, String> {

}
