package com.citiustech.impact.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="ethinicity_master")
@Data
@NoArgsConstructor
public class Ethinicity {

	@Id
	@Column(name = "ethinicity_id")
	private String id;
	
	@Column(name = "name")
	private String name;
}
