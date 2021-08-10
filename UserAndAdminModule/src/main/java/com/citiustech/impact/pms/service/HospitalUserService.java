package com.citiustech.impact.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.ProviderRegistration;
import com.citiustech.impact.pms.repository.HospitalUserRepository;

@Service
public class HospitalUserService {

	@Autowired
	HospitalUserRepository hospitalRepo;

	public List<ProviderRegistration> getUsers() {
		List<ProviderRegistration> users = hospitalRepo.findAll();
		return users;
	}

	public ProviderRegistration getUserByEmpId(String id) {
		ProviderRegistration user = hospitalRepo.findByEmployeeid(id);
		return user;
	}

//	public List<ProviderRegistration> getUserByName(String fname, String lname) {
//		List<ProviderRegistration> users = hospitalRepo.findByFirstnameOrLastname(fname, lname)
//		return users;
//	}

}
