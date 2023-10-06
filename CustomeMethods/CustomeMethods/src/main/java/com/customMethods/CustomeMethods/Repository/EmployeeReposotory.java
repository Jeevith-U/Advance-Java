package com.customMethods.CustomeMethods.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.customMethods.CustomeMethods.Model.Employee;

public interface EmployeeReposotory extends JpaRepository<Employee, Integer>{
	
	 Employee findByEmail(String email);
	 
	 Employee findByPhno(long phno) ;
	
	 List<Employee> findByAgeGreaterThan(int ageValue) ;
	 
	 @Query("select e from Employee e")
	 List<Employee> getAllEmployee() ;
	 
	 @Query("select e from Employee e where e.age = ?1")
	 List<Employee> getByEmployeAge(int age) ;
	 
	 @Query("select e from Employee e where e.email = ?1 and e.email = ?2")
	 Employee getByEmailAndPassword(String email, String oassword);
	 
	 @Query("select e from Employee e where e.name = :name")
	 Employee getByName(String name) ;
	 
	 @Query("select e from Employee e where e.phno = : myphnonum")
	 Employee getAllByPhno(@Param("myphnonum") long phno) ;
	 
}
