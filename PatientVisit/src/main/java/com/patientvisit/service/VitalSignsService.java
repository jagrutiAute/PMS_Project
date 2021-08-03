package com.patientvisit.service;

import com.patientvisit.dto.VitalSignsDTO;
import com.patientvisit.model.VitalSigns;

public interface VitalSignsService {

	public VitalSigns updateVitalSigns(VitalSignsDTO vtdto);
}
