package com.pathvariable.PathVariable.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pathvariable.PathVariable.model.Student;

@RestController
public class StudentController {
	
	@PostMapping("/sirStudent")
	public String recive(@RequestBody Student student) {
		return "Student Name is "+student.getName() ;
	}
}
