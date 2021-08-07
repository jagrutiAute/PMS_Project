package com.citiustech.impact.pms.procedure.model;

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

@Entity
@Table(name = "patient_procedure")
@Data
@NoArgsConstructor

public class PatientProcedure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String procedureDesc;
	private String createdBy;
	private Calendar createdDateNtime;
	private String modifiedBy;
	private Calendar modifiedDateNtime;
	private Boolean isProcedureActive;
	
	//dummy for now
	private Integer patientvisitId;
	
	@JoinColumn(name = "procedure_code")
	@OneToOne(cascade = CascadeType.ALL)
	private Procedure procedure;

}
