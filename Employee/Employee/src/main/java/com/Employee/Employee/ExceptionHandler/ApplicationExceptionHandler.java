package com.Employee.Employee.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.Employee.Employee.Entity.Employee;
import com.Employee.Employee.Exception.IdDoesNotFoundException;
import com.Employee.Employee.ResponseStructure.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(IdDoesNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idDoesNotPresentException(IdDoesNotFoundException exception){
		ResponseStructure<String> response = new ResponseStructure<String>() ;
		response.setStatuscode(HttpStatus.NOT_FOUND.value());
		response.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.NOT_FOUND) ;
	}

}
