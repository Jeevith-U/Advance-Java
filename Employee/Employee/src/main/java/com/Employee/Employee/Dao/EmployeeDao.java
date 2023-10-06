package com.Employee.Employee.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Employee.Employee.Entity.Employee;
import com.Employee.Employee.Repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	
	@Autowired
	private EmployeeRepository repo ;
	
	public Employee saveEmploye(Employee employee) {
		return repo.save(employee) ;
	}
	
	public Employee getEmployeeById(int id) {
		Optional<Employee> emp = repo.findById(id) ;
		if (emp.isPresent()) {
			return emp.get() ;
		}else
			return null ;
	}
}
