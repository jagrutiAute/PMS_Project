package com.citiustech.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.impact.pms.model.ProviderRegistration;


public interface ProviderRegistrationRepository extends JpaRepository<ProviderRegistration, Long> {
		

	public ProviderRegistration findByEmployeeid(String employeeid);
}
