package com.SpringWithDB.SpringWithDB.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringWithDB.SpringWithDB.Repository.StudentRepository;
import com.SpringWithDB.SpringWithDB.model.Student;

@RestController
@RequestMapping("/springStudent")
public class Controller {
	
	@Autowired
	private StudentRepository repo ;
	
	@PostMapping("/student")
	public String saveStudent(@RequestBody Student student) {
		
		repo.save(student) ;
		
		return "Student Is Saved" ;
	}
	
	@GetMapping("/student")
	public List<Student> getAllStudent(){
		return repo.findAll() ;
	}
	
	@GetMapping("/student/{roll}")
	public Student getStudentById(@PathVariable int roll) {
		
		Optional<Student> opt = repo.findById(roll) ;
		
		if (opt.isPresent()) {
			return opt.get() ;
		}
		return null;
	}
	
	@PutMapping("/student")
	public Student updateStudent(@RequestBody Student student) {
		return repo.save(student) ;
	}
	
	
	@DeleteMapping("/student/{roll}")
	public String deletStudent(@PathVariable int roll) {
		
		Optional<Student> opt = repo.findById(roll) ;
		
		if (opt.isPresent()) {
			repo.delete(opt.get()) ;
			return "Deleted Successfully" ;
		}else
			return "Unable to delete" ;
	}
}
