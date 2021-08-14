package com.citiustech.impact.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.Ethinicity;

import com.citiustech.impact.pms.repository.EthinicityRepository;

@RestController
@CrossOrigin(origins = "*")
public class EthinicityController {

	@Autowired
	EthinicityRepository ethinicityRepo;

	@GetMapping("/getEthinicityList")
	public ResponseEntity<List<Ethinicity>> getRaceList() {
		List<Ethinicity> ethinicityList = ethinicityRepo.findAll();

		System.out.println("ethinicityList ::  " + ethinicityList);

		return new ResponseEntity<List<Ethinicity>>(ethinicityList, HttpStatus.OK);

	}
}
