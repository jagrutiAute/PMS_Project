package com.citiustech.impact.pms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citiustech.impact.pms.model.ProviderRegistration;
import com.google.inject.Provider;

public interface HospitalUserRepository extends JpaRepository<ProviderRegistration, Integer> {

//	@Query(value = "select p.employee_id, p.first_name, p.last_name, r.role_name, p.date_of_birth, u.email_id from provider p join users u on p.users_id =u.id join role_master r on u.role_master_id =r.id", nativeQuery = true)
//	List<Object[]> findDetailsOfHuser();

	ProviderRegistration findByEmployeeid(String id);

//	List<ProviderRegistration> findByFirstnameOrLastname(String fname, String lname);

}
