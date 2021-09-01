package com.citiustech.impact.pms.procedure.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	
	private String pid;
	
	@Column(name="procedure_code")
	private String procedureCode;
	
	@Column(name ="procedure_desc")
	private String procedureDesc;
	
	private String createdBy;
	private Calendar createdDateNtime;
	private String modifiedBy;
	private Calendar modifiedDateNtime;
	
	@Column(name="is_procedure_dpricated")
	private String isProcedureDpricated;
	
	//dummy for now
	private Integer patientvisitId;
	
	//@JoinColumn(name = "procedure_code")
	//@OneToOne(cascade = CascadeType.ALL)
	//private Procedure procedure;

}
