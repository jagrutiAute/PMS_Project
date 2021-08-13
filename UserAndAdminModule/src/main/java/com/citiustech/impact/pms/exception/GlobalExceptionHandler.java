package com.citiustech.impact.pms.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.citiustech.impact.pms.model.Role;
import com.citiustech.impact.pms.model.ErrorDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler{
	
	@Autowired
	ErrorDetails errorDetails;
	
	@ExceptionHandler(RoleNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleRoleNotFound(RoleNotFoundException ex){
		errorDetails.setResponseCode(HttpStatus.BAD_REQUEST.value());
		
		errorDetails.setResponseMessage(ex.getMessage());
		//roleErrorDetails.setResponseCode();
		return new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST);
		
	}

	
}
