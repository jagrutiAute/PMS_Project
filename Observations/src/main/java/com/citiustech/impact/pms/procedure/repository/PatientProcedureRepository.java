package com.citiustech.impact.pms.procedure.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.citiustech.impact.pms.procedure.model.PatientProcedure;
import com.citiustech.impact.pms.procedure.model.Procedure;

public interface PatientProcedureRepository extends JpaRepository<PatientProcedure, Integer> {

		
	@Query("from PatientProcedure  where pid = ?1")
	public Optional<List<PatientProcedure>> getAllPatientProcedure(String pid);

	public Optional<List<PatientProcedure>> findByPid(String pid);
	
	List<PatientProcedure> findByPidAndDate(String pid, LocalDate d);

}
