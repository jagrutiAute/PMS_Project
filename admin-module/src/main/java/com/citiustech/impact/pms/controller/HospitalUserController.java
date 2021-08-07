package com.citiustech.impact.pms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.HospitalUser;
import com.citiustech.impact.pms.service.HospitalUserService;

@RestController
@CrossOrigin(origins = "*")
public class HospitalUserController {

	@Autowired
	HospitalUserService adminService;

	@GetMapping("/hospital-users/{hid}")
	public ResponseEntity<?> getHospitalUser(@PathVariable long hid) {
		Optional<HospitalUser> hospiatlUser = adminService.getHospitalUserById(hid);
		return new ResponseEntity<>(hospiatlUser, HttpStatus.OK);
	}
	
	@GetMapping("/hospital-users")
	public ResponseEntity<List<HospitalUser>> getHospitalUsers() {
		List<HospitalUser> hospiatlUsers = adminService.getAllHospitalUsers();
		return new ResponseEntity<List<HospitalUser>>(hospiatlUsers, HttpStatus.OK);
	}

	@PostMapping("/hospital-users/create")
	public ResponseEntity<String> addHospitalUser(@RequestBody HospitalUser hospitalUser) {
		String status = adminService.saveHospitalUser(hospitalUser);
		return new ResponseEntity<String>(status, HttpStatus.CREATED);
	}

	@PutMapping("/hospital-users/update/{hid}")
	public ResponseEntity<String> updateHospitalUser(@PathVariable long hid, @RequestBody HospitalUser hospitalUser) {
		String status = adminService.editHospitalUser(hid, hospitalUser);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	@DeleteMapping("/hospital-users/delete/{hid}")
	public ResponseEntity<?> deleteHospitalUser(@PathVariable long hid) {
		adminService.removeHospitalUser(hid);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
