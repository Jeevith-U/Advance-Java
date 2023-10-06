package com.customMethods.CustomeMethods.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customMethods.CustomeMethods.Model.Employee;
import com.customMethods.CustomeMethods.Repository.EmployeeReposotory;
import com.customMethods.CustomeMethods.ResponseStructure.ResponseStructure;
import com.customMethods.CustomeMethods.Service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service ;
	
	@Autowired
	private EmployeeReposotory repo ;
	
	@PostMapping("/employee")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee){
		
		ResponseStructure<Employee> response = new ResponseStructure<Employee>() ;
		response.setStatusCode(200);
		response.setMessage("success");
		response.setData(employee);
		service.saveEmployee(employee) ;
		return new ResponseEntity<ResponseStructure<Employee>>(response, HttpStatus.OK) ;
	}
	
//	@GetMapping("/employee/{id}")
//	public Optional<Employee> getEmployeeById(@PathVariable int id){
//		
//		return service.findEmployeeById(id) ;
//	}
	
//	@GetMapping("/employee/{phno}")
//	public Employee getEmployeeByPhno(@PathVariable long phno ){
//		Employee employee = repo.findByPhno(phno) ;
//		return employee ;
//	}
	
	@GetMapping("/employee/{age}")
	public List<Employee> findByAgeGreaterThan(@PathVariable int age){
		return repo.findByAgeGreaterThan(age) ;
	}
	
}
