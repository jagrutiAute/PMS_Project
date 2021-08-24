package com.citiustech.impact.pms.diagnoses.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="diagnosis_save")
public class DiagnosisSave {

	@Id
	private String diagnosis_code;
	private String diagnosis_description;
	
	@Column(columnDefinition="tinyint(1) default 1")
	private boolean diagnosis_is_deprecated;
	
	private String pid;
	private String phyid;
	
	
	
}
