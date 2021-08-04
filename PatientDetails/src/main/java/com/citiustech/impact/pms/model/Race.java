package com.citiustech.impact.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="race_master")
@Data
@NoArgsConstructor
public class Race {

	@Id
	@Column(name = "race_id")
	private String id;
	
	@Column(name = "name")
	private String name;
}
