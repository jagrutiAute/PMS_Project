package com.appointmentscheduling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointmentscheduling.model.SchedulingModel;
import com.appointmentscheduling.service.SchedulingService;

@CrossOrigin(origins = "*")
@RestController
public class SchedulingController {

	@Autowired
	private SchedulingService SchedulingService;
	
	@GetMapping("/users/scheduling")
	public ResponseEntity<List<SchedulingModel>> getScheduleDetails() {

		List<SchedulingModel> patientProfile = this.SchedulingService.getAllSchedulingDetails();
		return new ResponseEntity<List<SchedulingModel>>(patientProfile, HttpStatus.OK);

	}
}
