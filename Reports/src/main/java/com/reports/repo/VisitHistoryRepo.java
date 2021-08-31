package com.reports.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reports.model.MedicationSave;

public interface VisitHistoryRepo extends JpaRepository<MedicationSave,String>{

			List<MedicationSave> findByPid(String pid);
}
