package com.citiustech.impact.pms.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Component 
public class ErrorDetails {
	
	private int responseCode;
	private String responseMessage;
	

}
