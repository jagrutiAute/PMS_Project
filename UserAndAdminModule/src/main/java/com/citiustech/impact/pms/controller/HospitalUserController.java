package com.citiustech.impact.pms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.ProviderRegistration;
import com.citiustech.impact.pms.model.Users;
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

	@GetMapping("hospital-users/id/{eid}")
	public ResponseEntity<Optional<ProviderRegistration>> getUserByEId(@PathVariable String eid) {
		Optional<ProviderRegistration> huser = hospitalService.getUserByEmpId(eid);
		return new ResponseEntity<Optional<ProviderRegistration>>(huser, HttpStatus.OK);
	}

	@GetMapping("hospital-users/name/{name}")
	public ResponseEntity<List<ProviderRegistration>> getUserByName(@PathVariable String name) {
		List<ProviderRegistration> husers = hospitalService.getUserByName(name, name);
		return new ResponseEntity<List<ProviderRegistration>>(husers, HttpStatus.OK);
	}

	@PutMapping("hospital-users/id/{uid}/{status}")
	public ResponseEntity<Users> updateStatusByHospitalUserId(@PathVariable long uid, @PathVariable String status) {
		Users huser = hospitalService.updateStatus(uid, status);
		return new ResponseEntity<Users>(huser, HttpStatus.OK);
	}
}
