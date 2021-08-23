package com.citiustech.impact.pms.diagnoses.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.diagnoses.model.DiagnosisModel;
import com.citiustech.impact.pms.diagnoses.model.DiagnosisSave;
import com.citiustech.impact.pms.diagnoses.repository.DiagnosisSaveRepository;
import com.citiustech.impact.pms.diagnoses.repository.DiagnosisRepository;



@Service
public class DiagnosisService {

	static Logger log = Logger.getLogger(DiagnosisModel.class.getName());
	@Autowired
	private DiagnosisRepository diagnosisRepository;
	
	@Autowired
	private DiagnosisSaveRepository diagnosisSaveArrayListRepository;
	
	public List<DiagnosisModel> getDiagnosis() 
	{
	
		log.debug("inside getAllMedications() method of MedicationsServiceImpl class");

		return diagnosisRepository.findAll();
	}

	public void addDiagnosis(List<DiagnosisSave> diagnosisSaveArrayList) {
		
		diagnosisSaveArrayList.stream().forEach(a->System.out.println(a));
		diagnosisSaveArrayListRepository.saveAll(diagnosisSaveArrayList);
	}

	public List<DiagnosisSave> gettingAddedDiagnosis() {
		
		return diagnosisSaveArrayListRepository.findAll();
	}
}
