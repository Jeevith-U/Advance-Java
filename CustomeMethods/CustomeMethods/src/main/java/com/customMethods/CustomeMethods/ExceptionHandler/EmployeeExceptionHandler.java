package com.customMethods.CustomeMethods.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.customMethods.CustomeMethods.Model.Employee;
import com.customMethods.CustomeMethods.ResponseStructure.ResponseStructure;

@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ResponseStructure<String>> nullPointException(NullPointerException nullPointerException){
		
		ResponseStructure<String> response = new ResponseStructure<String>() ;
		response.setStatusCode(200) ;
		response.setMessage("success");
		response.setData("Dealing with NUll");
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage("message : "+ nullPointerException.getMessage());
		response.setData("Dont deal with null");
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.BAD_GATEWAY) ;
	}
	

}
