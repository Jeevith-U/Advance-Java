package com.tyss.ems_springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tyss.ems_springmvc.dto.Employee;

@Component
public class EmployeeDao {
	
	@Autowired
	EntityManager entityManager ;
	
	
	public void saveEmployee(Employee employee) {

		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	}
	
	public Employee findeEmployee(int id) {
		Employee employee = entityManager.find(Employee.class, id) ;
		return employee;
	}
	
	public boolean updateEmployee(Employee employee) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		entityTransaction.begin();
		entityManager.merge(employee) ;
		entityTransaction.commit();
		
		return true ;
	}
	
	public boolean deleteEmployee(Employee employee) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		entityTransaction.begin();
		entityManager.remove(employee);
		entityTransaction.commit();
		
		return true ;
	}
	
	public List<Employee> findAllEmployee(){
		  Query query = entityManager.createQuery("from Employee") ;
		 return query.getResultList() ;
	}
}
