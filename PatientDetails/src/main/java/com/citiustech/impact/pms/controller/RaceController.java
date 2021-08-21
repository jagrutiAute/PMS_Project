package com.citiustech.impact.pms.controller;

import java.util.List;

import org.apache.log4j.Logger;
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

	static Logger log = Logger.getLogger(RaceController.class.getName());

	@Autowired
	RaceRepository raceRepo;

	@GetMapping("/getRaceList")
	public ResponseEntity<List<Race>> getRaceList() {

		log.debug("inside getRaceList() method of RaceController class");
		log.debug("calling findAll() method of RaceRepository interface");
		
		List<Race> raceList = raceRepo.findAll();

		System.out.println("raceList ::  " + raceList);

		return new ResponseEntity<List<Race>>(raceList, HttpStatus.OK);

	}
}
