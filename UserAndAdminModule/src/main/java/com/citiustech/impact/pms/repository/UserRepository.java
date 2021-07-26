package com.citiustech.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.impact.pms.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	 Users findByEmail(String email);

	Users findByEmailAndPassword(String email, String pwd);
}
