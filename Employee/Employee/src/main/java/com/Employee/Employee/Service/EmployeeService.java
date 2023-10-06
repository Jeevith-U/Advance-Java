package com.Employee.Employee.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Employee.Employee.Dao.EmployeeDao;
import com.Employee.Employee.Entity.Employee;
import com.Employee.Employee.Exception.IdDoesNotFoundException;
import com.Employee.Employee.ResponseStructure.ResponseStructure;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao dao ;
	
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		Employee employeee = dao.saveEmploye(employee) ;
		
		ResponseStructure<Employee> response = new ResponseStructure<Employee>() ;
		response.setStatuscode(HttpStatus.CREATED.value());
		response.setMessage("success");
		response.setBody(employeee);
		
		return new ResponseEntity<ResponseStructure<Employee>>(response, HttpStatus.CREATED) ;
	}
	
	public ResponseEntity<ResponseStructure<Employee>> getEmployeeById(int id)
	{
		Employee employee = dao.getEmployeeById(id) ;
		if (employee != null) {
			
			ResponseStructure<Employee> response = new ResponseStructure<Employee>() ;
			response.setStatuscode(HttpStatus.FOUND.value());
			response.setMessage(HttpStatus.FOUND.getReasonPhrase());
			response.setBody(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(response,HttpStatus.FOUND) ;
		}else {
			throw new IdDoesNotFoundException("Id : "+id+" not present in the DB") ;
		}
	}
}
