package com.citiustech.impact.pms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.citiustech.impact.pms.model.MedicationSave;

@Repository
@EnableJpaRepositories
public interface MedicationSaveRepository extends JpaRepository<MedicationSave, String> {
	List<MedicationSave> findByPidAndDate(String pid, LocalDate date);
}
