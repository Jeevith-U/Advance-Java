package com.StudentManageSystem.StudentManageSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.StudentManageSystem.StudentManageSystem.Entity.Student;
import com.StudentManageSystem.StudentManageSystem.ResponseStructure.StudentResponseStructure;
import com.StudentManageSystem.StudentManageSystem.Service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service ;
	
	@PostMapping("/student")
	public ResponseEntity<StudentResponseStructure<Student>> saveStudent(@RequestBody Student student) {
		 return service.saveStudent(student) ;
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<StudentResponseStructure<Student>> findById(@PathVariable int id){
		return service.findStudentById(id) ;
	}
	
}
