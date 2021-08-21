package com.citiustech.impact.pms.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.ISActive;
import com.citiustech.impact.pms.model.ProviderRegistration;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.HospitalUserRepository;
import com.citiustech.impact.pms.repository.UserRepository;

@Service
public class HospitalUserService {

	static Logger log = Logger.getLogger(HospitalUserService.class.getName());

	@Autowired
	HospitalUserRepository hospitalRepo;

	@Autowired
	UserRepository userRepo;

	// to retrieve all data about hospital users
	public List<ProviderRegistration> getUsers() {
		
		log.debug("inside getUsers() method of HospitalUserService class");
		log.debug("inside findAll() method of HospitalUserRepository class");

		List<ProviderRegistration> users = hospitalRepo.findAll();
		return users;
	}

	// to retrieve data by hospital user employee id
	public Optional<ProviderRegistration> getUserByEmpId(String id) {
		
		log.debug("inside getUserByEmpId() method of HospitalUserService class");
		log.debug("inside findByEmployeeid() method of HospitalUserRepository class");

		Optional<ProviderRegistration> user = hospitalRepo.findByEmployeeid(id);
		return user;
	}

	// to retrieve data by hospital user fname or lname
	public List<ProviderRegistration> getUserByName(String fname, String lname) {
		
		log.debug("inside getUserByName() method of HospitalUserService class");
		log.debug("inside findByFirstNameOrLastName() method of HospitalUserRepository class");

		
		List<ProviderRegistration> users = hospitalRepo.findByFirstNameOrLastName(fname, lname);
		return users;
	}

	// to update status of hospital user buy user id
	public Users updateStatus(long uid, String status) {
		
		log.debug("inside updateStatus() method of HospitalUserService class");
		log.debug("inside findById() method of HospitalUserRepository class");

		Users u = userRepo.findById(uid).get();
		u.setIsActive(ISActive.valueOf(status));
		return userRepo.save(u);
	}

}
