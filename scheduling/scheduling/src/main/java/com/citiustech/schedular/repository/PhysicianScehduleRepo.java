package com.citiustech.schedular.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.schedular.model.PhysicianSchedule;

public interface PhysicianScehduleRepo extends JpaRepository<PhysicianSchedule, Integer> {
	
		public PhysicianSchedule findByPhyidAndDate(String phyid,LocalDate date);
		public List<PhysicianSchedule> findByPhyid(String phyid);
		//public PhysicianSchedule findByDate(LocalDate date);
		
	
}
