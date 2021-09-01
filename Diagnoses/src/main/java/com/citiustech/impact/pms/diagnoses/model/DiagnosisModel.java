package com.citiustech.impact.pms.diagnoses.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="diagnosis_master_new")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisModel {

	@Id
	private Integer id;
	private String diagnosis_code;
	private String diagnosis_description;
	
	//@Column(columnDefinition="tinyint(1) default 1")
	private String diagnosis_is_deprecated;
	
}
