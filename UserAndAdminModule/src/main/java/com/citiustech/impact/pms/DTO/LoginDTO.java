package com.citiustech.impact.pms.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginDTO {
	
	private String email;
	private String password;

}
