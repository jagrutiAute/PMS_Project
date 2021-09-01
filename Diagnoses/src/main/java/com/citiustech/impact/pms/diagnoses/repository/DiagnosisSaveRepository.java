package com.citiustech.impact.pms.diagnoses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.impact.pms.diagnoses.model.DiagnosisSave;


@Repository

public interface DiagnosisSaveRepository extends JpaRepository<DiagnosisSave, Integer> {

	
	List<DiagnosisSave> findByPid(String id);
	
	
}
