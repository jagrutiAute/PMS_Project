package com.citiustech.impact.pms.procedure.model;

import javax.persistence.Column;
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
	@Column(name="procedure_code")
	private String procedureCode;
	
	@Column(name ="procedure_desc")
	private String procedureDesc;
	
	@Column(name="is_procedure_dpricated")
	private String isProcedureDpricated;
	
}
