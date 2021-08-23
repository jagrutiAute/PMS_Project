package com.citiustech.schedular.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citiustech.schedular.model.Schedular;

public interface SchedularRepo extends JpaRepository<Schedular, Integer> {
		
		Schedular findByPhyidAndDateAndTime(String phy_id,LocalDate date,String time);
		List<Schedular> findByPhyidAndDateAndBookedAndIscancelled(String phid,LocalDate date,boolean book_status,boolean isCancelled );
		//List<Schedular> findByPhyidAndDateAndBooked(String phid,LocalDate date,boolean book_status);
		@Query("select a from Schedular a where a.date >=:date and phyid=:pid and isCancelled=:st ")
		List<Schedular> findAllWithDateAfter(LocalDate date,String pid,boolean st);
		
		Schedular findByPhyidAndDateAndPidAndTime(String phyid,LocalDate date,String pid,String time);
		Schedular findByPidAndTimeAndDate(String pid,String time,LocalDate date);
}
