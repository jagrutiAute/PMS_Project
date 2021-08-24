package com.citiustech.impact.pms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citiustech.impact.pms.DTO.PhysicianNameDTO;
import com.citiustech.impact.pms.model.ProviderRegistration;

public interface HospitalUserRepository extends JpaRepository<ProviderRegistration, Integer> {

//	@Query(value = "select p.employee_id, p.first_name, p.last_name, r.role_name, p.date_of_birth, u.email_id from provider p join users u on p.users_id =u.id join role_master r on u.role_master_id =r.id", nativeQuery = true)
//	List<Object[]> findDetailsOfHuser();

	Optional<ProviderRegistration> findByEmployeeid(String id);

	List<ProviderRegistration> findByFirstNameOrLastName(String fname, String lname);
	
	List<ProviderRegistration> findByFirstNameAndLastName(String fname, String lname);

	@Query(value="select pr.employee_id from pms.provider pr join pms.users pu on pr.users_id=pu.id AND pu.role_master_id=2;", nativeQuery = true)
	List<String> findAllId();

	@Query(value="select firstName, lastName from ProviderRegistration where employeeid=:phyid")
	List<PhysicianNameDTO> findById(@Param("phyid") String phyid);
	
	

}
