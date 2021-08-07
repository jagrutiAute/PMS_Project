package com.citiustech.impact.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.model.Race;

import com.citiustech.impact.pms.repository.RaceRepository;

@RestController
@CrossOrigin(origins = "*")
public class RaceController {

	@Autowired
	RaceRepository raceRepo;

	@GetMapping("/getRaceList")
	public ResponseEntity<List<Race>> getRaceList() {

		List<Race> raceList = raceRepo.findAll();

		System.out.println("raceList ::  " + raceList);

		return new ResponseEntity<List<Race>>(raceList, HttpStatus.OK);

	}
}
