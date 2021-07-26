package com.citiustech.impact.pms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.impact.pms.model.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmailID(String email);
	
	User findByEmailIDAndPassword(String email, String password);
	

<<<<<<< HEAD
	 Users findByEmail(String email);

	Users findByEmailAndPassword(String email, String pwd);
}
=======
}
>>>>>>> b707ea0bb99d2dafbba5d70514928c2fbc430850
