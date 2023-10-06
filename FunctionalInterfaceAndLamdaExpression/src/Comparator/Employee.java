package Comparator;

import java.util.Comparator;
import java.util.Objects;

public class Employee {
	
	private int id ;
	private String name ;
	private String password ;
	private long phno ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	
	@Override
	public boolean equals(Object obj) {
		Employee emp = (Employee)obj ;
		if (this.id == emp.id && this.name == emp.name && this.password == emp.password && this.phno == emp.phno) {
			return true ;
		}else
			return false ;
	}
	
	@Override
	public int hashCode() {
		
		Integer id1 = id ;
		String name1 = name ;
		String password1 = password ;
		long phno1 = phno ;
		
		return id1.hashCode()+name1.hashCode()+password1.hashCode() ;
		
	}
	
}
