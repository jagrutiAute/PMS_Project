package com.citiustech.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.citiustech.impact.pms.model.Users;

/*
 * 
 * Created Repository interface to extends JpaRepository.
 * 
*/

@Repository
public interface LoginRepository extends JpaRepository<Users, Long>{
	Users findByEmailAndPassword(String email, String password);
	
	Users findByEmail(String email);
	Users findByPassword(String password);
 
}