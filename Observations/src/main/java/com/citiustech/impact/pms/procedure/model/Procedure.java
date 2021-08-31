package com.citiustech.impact.pms.procedure.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "procedure_master")
@Data
@NoArgsConstructor
public class Procedure {

	@Id
	private Integer id;
	private String procedureCode;
	private String procedureDesc;
	private Boolean isProcedureDpricated;
	
}
