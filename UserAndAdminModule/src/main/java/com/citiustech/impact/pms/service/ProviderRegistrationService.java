package com.citiustech.impact.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.ProviderRegistration;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.ProviderRegistrationRepository;
import com.citiustech.impact.pms.repository.UserRepository;

@Service
public class ProviderRegistrationService {

	@Autowired
	ProviderRegistrationRepository providerRegRepo;

	@Autowired
	UserRepository userRepo;

	public boolean registerProvider(ProviderRegistration regProvider, String email) {

		ProviderRegistration providerReg = providerRegRepo.findByEmployeeid(regProvider.getEmployeeid());
		//Users users = userRepo.findByEmail(email);

		if ((providerReg == null)) {

			ProviderRegistration status = providerRegRepo.save(regProvider);
			
			return true;

		}
		
		
		return false;

	}

}