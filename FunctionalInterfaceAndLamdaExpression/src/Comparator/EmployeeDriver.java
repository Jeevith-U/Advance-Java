package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class EmployeeDriver {
	
	public static void main(String[] args) {
		
		List<Employee> empList = new ArrayList<Employee>() ;
		
		Employee employee = new Employee() ;
		employee.setId(103);
		employee.setName("Meera");
		employee.setPassword("Meera@33%%");
		employee.setPhno(894765734);
		
		Employee employee1 = new Employee() ;
		employee1.setId(101);
		employee1.setName("Jeevith");
		employee1.setPassword("jeevi@33%%");
		employee1.setPhno(99065323);
		
		Employee employee2 = new Employee() ;
		employee2.setId(102);
		employee2.setName("san");
		employee2.setPassword("san@33%%");
		employee2.setPhno(982873223);
		
		empList.add(employee) ;
		empList.add(employee1) ;
		empList.add(employee2) ;
		
		HashSet<Employee> setEmployees = new HashSet <>(empList) ;
		
		System.out.println(setEmployees);
		
		Collections.sort(empList, (e1, e2) -> e1.getId() > e2.getId() ?1 :-1);
		
		for (Employee employeee : empList) {
            System.out.println("ID: " + employeee.getId() + ", Name: " + employeee.getName() + ", Password: " + employeee.getPassword() + ", Phone: " + employeee.getPhno());
        }
	}

	private static HashSet<Employee> HashSet(List<Employee> empList) {
		// TODO Auto-generated method stub
		return null;
	}
}
