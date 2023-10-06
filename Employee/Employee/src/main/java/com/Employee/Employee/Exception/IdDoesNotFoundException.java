package com.Employee.Employee.Exception;

public class IdDoesNotFoundException extends RuntimeException {
	
	private String message  = "Id is Not Present" ;
	public IdDoesNotFoundException() {
		
	}
	public IdDoesNotFoundException(String message) {
		this.message = message ;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

}
