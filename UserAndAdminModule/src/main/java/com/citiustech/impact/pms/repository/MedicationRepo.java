package com.citiustech.impact.pms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.citiustech.impact.pms.model.Medication;

@Repository
@EnableJpaRepositories
public interface MedicationRepo extends JpaRepository<Medication, Integer>{

	@Query(value="select * from productmedication limit 500", nativeQuery = true)
	List<Medication> findAllMedication();

}
