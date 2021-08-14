package com.citiustech.impact.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.HospitalUser;
import com.citiustech.impact.pms.repository.HospitalUserRepository;

@Service
public class HospitalUserServiceImpl implements HospitalUserService {

	/*@Autowired
	HospitalUserRepository adminRepo;

	@Override
	public Optional<HospitalUser> getHospitalUserById(long id) {
		Optional<HospitalUser> user = adminRepo.findById(id);
		return user;
	}

	@Override
	public List<HospitalUser> getAllHospitalUsers() {
		return adminRepo.findAll();
	}

	@Override
	public String saveHospitalUser(HospitalUser h) {
		HospitalUser savedUser = adminRepo.save(h);
		return "Hospital User created Successfully ";
	}

	@Override
	public String editHospitalUser(long id, HospitalUser h) {
		Optional<HospitalUser> user = adminRepo.findById(id);

		if (user.isPresent()) {
			HospitalUser _user = user.get();
//			_user.setId(h.getId());
			_user.setFirstName(h.getFirstName());
			_user.setLastName(h.getLastName());
			_user.setDateOfJoining(h.getDateOfJoining());
			_user.setStatus(h.getStatus());
			HospitalUser updatedUser = adminRepo.save(_user);
		}
		return "Hospital User updated Successfully ";
	}

	@Override
	public void removeHospitalUser(long id) {
		adminRepo.deleteById(id);
	}*/

}
