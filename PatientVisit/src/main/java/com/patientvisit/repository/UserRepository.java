package com.patientvisit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patientvisit.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	 Users findByEmail(String email);
	 Users findByEmailAndPassword(String email,String password);
}
