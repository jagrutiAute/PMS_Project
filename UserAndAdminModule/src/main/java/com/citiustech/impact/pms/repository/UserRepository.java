package com.citiustech.impact.pms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citiustech.impact.pms.model.PatientProfile;
import com.citiustech.impact.pms.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByEmail(String email);

	Users findByEmailAndPassword(String email, String password);
	
	

}
