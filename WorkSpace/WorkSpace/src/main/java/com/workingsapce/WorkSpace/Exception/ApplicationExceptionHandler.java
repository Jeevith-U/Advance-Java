package com.workingsapce.WorkSpace.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.workingsapce.WorkSpace.ResponseStructure.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> nullPointException(IdNotFoundException idNotFoundException) {
		
		ResponseStructure<String> response = new ResponseStructure<String>() ;
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setMessage("message : "+ idNotFoundException.getMessage());
		response.setData(idNotFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.NOT_FOUND) ;
	}
	
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ResponseStructure<String>> nullPointException(NullPointerException nullPointerException) {
		
		ResponseStructure<String> response = new ResponseStructure<String>() ;
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage("message : "+ nullPointerException.getMessage());
		response.setData("Dont deal with null");
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.BAD_GATEWAY) ;
	}
}
