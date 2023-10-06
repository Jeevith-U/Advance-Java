package com.customMethods.CustomeMethods.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customMethods.CustomeMethods.Model.Employee;
import com.customMethods.CustomeMethods.Repository.EmployeeReposotory;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeReposotory repo ;
	
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee) ;
	}
	
	public Optional<Employee> findEmployeeById(int id) {
		return repo.findById(id) ;
	}
	
	public Employee updateEmployee(Employee employee) {
		
		Optional<Employee> emp = findEmployeeById(employee.getId()) ;
		if(emp != null) {
		return repo.save(employee) ;
		
		}
		return null;
	}
	
	public boolean deleteEmployee(Employee employee) {
		Optional<Employee> emp = findEmployeeById(employee.getId()) ;
		
		if (emp.isPresent()) {
			repo.delete(employee);
			return true ;
		}
		return false;
	}
}
