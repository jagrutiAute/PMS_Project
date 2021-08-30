package com.patientvisit.service;

import java.util.Optional;

import com.patientvisit.dto.VitalSignsDTO;
import com.patientvisit.model.VitalSigns;

public interface VitalSignsService {

	public VitalSigns updateVitalSigns(VitalSignsDTO vtdto);
	public Optional<VitalSigns> getVitalSigns(String pid);
	
}
