package com.citiustech.impact.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.ProviderRegistration;
import com.citiustech.impact.pms.service.HospitalUserService;

@RestController
@CrossOrigin(origins = "*")
public class HospitalUserController {

	@Autowired
	HospitalUserService hospitalService;

	@GetMapping("hospital-users")
	public ResponseEntity<List<ProviderRegistration>> getUsers() {
		List<ProviderRegistration> husers = hospitalService.getUsers();
		return new ResponseEntity<List<ProviderRegistration>>(husers, HttpStatus.OK);
	}

	@GetMapping("hospital-users/{eid}")
	public ResponseEntity<ProviderRegistration> getUserByEId(@PathVariable String eid) {
		ProviderRegistration huser = hospitalService.getUserByEmpId(eid);
		return new ResponseEntity<ProviderRegistration>(huser, HttpStatus.OK);
	}

//	@GetMapping("hospital-users/name/{fname}{lname}")
//	public ResponseEntity<List<ProviderRegistration>> getUserByName(@PathVariable String fname,
//			@PathVariable String lname) {
//		List<ProviderRegistration> husers = hospitalService.getUserByName(fname, lname);
//		return new ResponseEntity<List<ProviderRegistration>>(husers, HttpStatus.OK);
//	}

}
