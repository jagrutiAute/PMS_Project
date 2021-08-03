package com.citiustech.impact.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.HospitalUser;
import com.citiustech.impact.pms.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepo;

	@Override
	public List<HospitalUser> getAllHospitalUsers() {

		return adminRepo.findAll();
	}

//	@Override
//	public HospitalUser createHopitalUser() {
//		// TODO Auto-generated method stub
//		return adminRepo.save(entity);
//	}

}
