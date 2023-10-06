package com.Employee.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.Employee.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	

}
