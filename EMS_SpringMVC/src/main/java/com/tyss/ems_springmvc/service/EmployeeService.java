package com.tyss.ems_springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tyss.ems_springmvc.dao.EmployeeDao;
import com.tyss.ems_springmvc.dto.Employee;

@Component
public class EmployeeService {
	
	@Autowired
	EmployeeDao dao ;
	
	public boolean saveEmployee(Employee employee) {
		if(employee != null) {
			dao.saveEmployee(employee);
			return true ;
		}
		return false ;
	}
	
	public boolean updateEmployee(Employee employee) {
		if(employee != null) {
			dao.updateEmployee(employee) ;
			return true ;
		}
		return false ;
	}
	
	public List<Employee> findAllEmployee(){
		return dao.findAllEmployee() ;
	}
	
	public Employee findEmployee(int id) {
		
			 return dao.findeEmployee(id) ;
			
	}
	
	public boolean deleteEmploye(Employee employee) {
		if(employee != null) {
			dao.deleteEmployee(employee) ;
			return true ;
		}
		return false ;
	}
	
}
