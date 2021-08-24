package com.citiustech.impact.pms.diagnoses.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="diagnosis_master")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisModel {

	@Id
	private String diagnosis_code;
	private String diagnosis_description;
	
	@Column(columnDefinition="tinyint(1) default 1")
	private boolean diagnosis_is_deprecated;
	
}
