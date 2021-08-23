package com.citiustech.impact.pms.allergies.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citiustech.impact.pms.allergies.model.AllergyDetails;

public interface AllergyDetailsRepository extends JpaRepository<AllergyDetails, Integer> {

	@Query("from AllergyDetails  where pid = ?1")
	public Optional<List<AllergyDetails>> getAllPrtientAllergies(String pid);

	//@Transactional
	//@Modifying
	//@Query("delete from AllergyDetails  where pid = ?1 and id = ?2")
	//public void deletePrtientAllergies(String pid, Integer id);

	@Transactional
	@Modifying 
	@Query("delete from AllergyDetails f where f.pid=:pid and f.id=:id") 
	public void deletePrtientAllergies(@Param("pid") String pid, @Param("id") int id);

}
