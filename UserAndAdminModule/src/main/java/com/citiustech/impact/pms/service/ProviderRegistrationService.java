package com.citiustech.impact.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.ProviderRegistration;
import com.citiustech.impact.pms.repository.ProviderRegistrationRepository;

@Service
public class ProviderRegistrationService {
	
	@Autowired
	ProviderRegistrationRepository providerRegRepo;

	public boolean registerProvider(ProviderRegistration regProvider) {
		
		if(providerRegRepo.findByEmployeeid(regProvider.getEmployeeid()) == null) {
			
			System.out.println("providerRegRepo.findByEmployeeId(regProvider.getEmployeeid()) :: "+providerRegRepo.findByEmployeeid(regProvider.getEmployeeid()));
			
			ProviderRegistration status= providerRegRepo.save(regProvider);
			
			//System.out.println("status   :::::::   "+status);
			return true;
			
			  }else return false;
			 
		
		
	}

	
	
}
