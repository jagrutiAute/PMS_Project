package com.citiustech.impact.pms.model;

import java.time.LocalDate;



import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalUser {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfJoining;
	private String status;
}
