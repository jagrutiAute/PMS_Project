package com.citiustech.impact.pms.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.controller.MedicationController;
import com.citiustech.impact.pms.exception.RoleNotFoundException;
import com.citiustech.impact.pms.model.Role;
import com.citiustech.impact.pms.repository.RoleRepository;

@Service
public class RoleService {
	
	static Logger log = Logger.getLogger(MedicationController.class.getName());

	@Autowired
	RoleRepository roleRepository;

	public List<Role> getRoles() {
		
		log.debug("inside getRoles() method of RoleService class");
		log.debug("calling findAll() of RoleRepository class");
		
		
		List<Role> roleList = roleRepository.findAll();
		System.out.println(roleList);
		if(!roleList.isEmpty())
		return roleList;
		else
		 throw new RoleNotFoundException("Role Not FOund");
	}

}
