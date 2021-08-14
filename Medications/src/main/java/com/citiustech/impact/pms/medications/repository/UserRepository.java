package com.citiustech.impact.pms.medications.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.impact.pms.medications.model.Users;



public interface UserRepository extends JpaRepository<Users, Integer>{

	 Users findByEmail(String email);
	 Users findByEmailAndPassword(String email,String password);
}
