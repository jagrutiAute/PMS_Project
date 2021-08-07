package com.citiustech.impact.pms.diagnoses.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
@Table(name = "patient_diagnosis")
@Data
@NoArgsConstructor
public class PatientDiagnosis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String diagnosisDesc;
	private String createdBy;
	private Calendar createdDateNtime;
	private String modifiedBy;
	private Calendar modifiedDateNtime;
	private Boolean isDiagosisActive;
	
	//dummy for now
	private Integer patientVisit;
	
	@JoinColumn(name = "dignosis_code")
	@OneToOne(cascade = CascadeType.ALL)
	private Diagnoses diagnosis;
}
