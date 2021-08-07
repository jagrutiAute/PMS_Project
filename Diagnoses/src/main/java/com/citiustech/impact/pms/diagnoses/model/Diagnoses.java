package com.citiustech.impact.pms.diagnoses.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dignosis_master")
@Data
@NoArgsConstructor

public class Diagnoses {

	@Id
	private Integer dignosisCode;
	private String dignosisDesc;
	private boolean isDepricated;
}
