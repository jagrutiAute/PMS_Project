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
<<<<<<< HEAD
=======
}
||||||| 78dff94
	 Users findByEmail(String email);
}
=======
>>>>>>> ebdf04721f462af1cc6faab3a2c978d371240229
	 Users findByEmail(String email);

	Users findByEmailAndPassword(String email, String pwd);
}
<<<<<<< HEAD
=======
}
>>>>>>> b707ea0bb99d2dafbba5d70514928c2fbc430850
=======
>>>>>>> 8c23b399729fd76973e53460bbd8c7cc648c8d6f
>>>>>>> ebdf04721f462af1cc6faab3a2c978d371240229
