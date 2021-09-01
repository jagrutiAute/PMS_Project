package com.citiustech.schedular.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citiustech.schedular.model.Schedular;

public interface SchedularRepo extends JpaRepository<Schedular, Integer> {
		
		Schedular findByPhyidAndDateAndTime(String phy_id,LocalDate date,String time);
		//List<Schedular> findByPhyidAndDateAndBookedAndIscancelled(String phid,LocalDate date,boolean book_status,boolean iscancelled);
		List<Schedular> findByPhyidAndDateAndBooked(String phid,LocalDate date,boolean book_status);
		//List<Schedular> findByPhyidAndDateAndBookedAndIscancelled(String phid,LocalDate date,boolean book_status,boolean isCancelled );
		//List<Schedular> findByPhyidAndDateAndBooked(String phid,LocalDate date,boolean book_status);
	
	  @Query("select a from Schedular a where a.date >=:date and phyid=:pid and iscancelled=:st "
	  ) List<Schedular> findAllWithDateAfter(LocalDate date,String pid,boolean st);
	  
	  @Query("select a from Schedular a where a.date >=:date and pid=:pid and iscancelled	=:st "
			  ) List<Schedular> findAllWithDateAfterforpatient(LocalDate date,String pid,boolean st);
	 
		
	/*
	 * @Query(value =
	 * "from Schedular  where yourDate BETWEEN :startDate AND :endDate AND :phyid AND :isCancelled"
	 * ) public List<Schedular> getAllBetweenDates(@Param("startDate")LocalDate
	 * startDate,@Param("endDate")LocalDate endDate,@Param("phyid") String
	 * phyid,@Param("isCancelled") boolean isCancelled);
	 */
		
		
		Schedular findByPhyidAndDateAndPidAndTime(String phyid,LocalDate date,String pid,String time);
		Schedular findByPidAndTimeAndDate(String pid,String time,LocalDate date);
		@Query("select a from Schedular a where  pid=:pid and isCancelled=:st ")
		List<Schedular> findByPidAndIscancelled(String pid,boolean st);
		
}
