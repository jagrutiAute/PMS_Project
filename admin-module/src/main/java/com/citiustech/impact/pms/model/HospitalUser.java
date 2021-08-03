package com.citiustech.impact.pms.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalUser {
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String doj;
	private String status;	
}
