package com.citiustech.impact.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.Role;
import com.citiustech.impact.pms.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;

	public List<Role> getRoles() {
		
		List<Role> roleList = roleRepository.findAll();
		
		return roleList;
	}

}
