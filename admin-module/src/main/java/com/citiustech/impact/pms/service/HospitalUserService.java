package com.citiustech.impact.pms.service;

import java.util.List;
import java.util.Optional;

import com.citiustech.impact.pms.model.HospitalUser;

public interface HospitalUserService {
	public Optional<HospitalUser> getHospitalUserById(long id);

	public List<HospitalUser> getAllHospitalUsers();

	public String saveHospitalUser(HospitalUser h);

	public String editHospitalUser(long id, HospitalUser h);

	public void removeHospitalUser(long id);

}
