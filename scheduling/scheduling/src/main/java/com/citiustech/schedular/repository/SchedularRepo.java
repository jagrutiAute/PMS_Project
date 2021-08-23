package com.citiustech.schedular.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.schedular.model.Schedular;

public interface SchedularRepo extends JpaRepository<Schedular, Integer> {
		
		Schedular findByPhyidAndDateAndTime(String phy_id,LocalDate date,String time);
		//List<Schedular> findByPhyidAndDateAndBookedAndIscancelled(String phid,LocalDate date,boolean book_status,boolean iscancelled);
		List<Schedular> findByPhyidAndDateAndBooked(String phid,LocalDate date,boolean book_status);
		Schedular findByPidAndTimeAndDate(String pid,String time,LocalDate date);
}
