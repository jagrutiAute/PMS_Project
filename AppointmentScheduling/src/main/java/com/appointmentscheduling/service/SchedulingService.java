package com.appointmentscheduling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointmentscheduling.model.SchedulingModel;
import com.appointmentscheduling.repo.SchedulingRepo;

@Service
public class SchedulingService {

	@Autowired
	private SchedulingRepo schedulingRepo;
	
	public List<SchedulingModel> getAllSchedulingDetails() {
		
		
		return schedulingRepo.findAll();
	}

}
