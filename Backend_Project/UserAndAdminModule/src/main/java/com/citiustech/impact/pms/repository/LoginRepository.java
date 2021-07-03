package com.citiustech.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.citiustech.impact.pms.model.Login;

/*
 * 
 * Created Repository interface to extends JpaRepository.
 * 
*/

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
	Login findByEmailAndPassword(String email, String password);
 
}