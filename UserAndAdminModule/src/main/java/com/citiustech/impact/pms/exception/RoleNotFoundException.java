package com.citiustech.impact.pms.exception;

public class RoleNotFoundException extends RuntimeException {

	String message;
	public RoleNotFoundException(String s){
		message=s;
	}
	
}
