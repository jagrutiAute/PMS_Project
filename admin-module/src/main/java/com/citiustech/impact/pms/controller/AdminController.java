package com.citiustech.impact.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.HospitalUser;
import com.citiustech.impact.pms.service.AdminService;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("/hospital-users")
	public ResponseEntity<List<HospitalUser>> getHospitalUsers() {
		List<HospitalUser> hospiatlUsers = adminService.getAllHospitalUsers();
		return new ResponseEntity<List<HospitalUser>>(hospiatlUsers, HttpStatus.OK);

	}
}
