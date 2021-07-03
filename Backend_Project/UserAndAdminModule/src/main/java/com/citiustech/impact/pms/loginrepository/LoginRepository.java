package com.citiustech.impact.pms.loginrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.impact.pms.logindomain.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
	Login findByEmailAndPassword(String email, String password);
 
}