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
}
||||||| 78dff94
	 Users findByEmail(String email);
}
=======
	 Users findByEmail(String email);

	Users findByEmailAndPassword(String email, String pwd);
}
>>>>>>> 8c23b399729fd76973e53460bbd8c7cc648c8d6f
