package com.citiustech.impact.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.Role;
import com.citiustech.impact.pms.service.RoleService;

@RestController
@CrossOrigin(origins = "*")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@GetMapping("/getRoles")
	
	public List<Role> getRoles(){
		
		List<Role> role = roleService.getRoles();
		//System.out.println("role  :::::::   "+role);
		return role;
		
	}
}
