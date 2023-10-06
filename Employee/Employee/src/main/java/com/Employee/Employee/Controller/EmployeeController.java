package com.Employee.Employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Employee.Entity.Employee;
import com.Employee.Employee.ResponseStructure.ResponseStructure;
import com.Employee.Employee.Service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service ;
	
	@PostMapping("/employee")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee){
		return service.saveEmployee(employee) ;
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<ResponseStructure<Employee>> getEmployee(@PathVariable int id){
		return service.getEmployeeById(id) ;
	}
}
