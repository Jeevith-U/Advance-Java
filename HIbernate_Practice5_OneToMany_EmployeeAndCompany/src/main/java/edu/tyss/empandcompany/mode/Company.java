package edu.tyss.empandcompany.mode;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	private int id ;
	private String name ;
	private String GSTno ;
	private String registerNum ;

	@OneToMany
	private List<Employe> listOfEmp ;

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

	public String getGSTno() {
		return GSTno;
	}

	public void setGSTno(String gSTno) {
		GSTno = gSTno;
	}

	public String getRegisterNum() {
		return registerNum;
	}

	public void setRegisterNum(String registerNum) {
		this.registerNum = registerNum;
	}

	public List<Employe> getListOfEmp() {
		return listOfEmp;
	}

	public void setListOfEmp(List<Employe> listOfEmp) {
		this.listOfEmp = listOfEmp;
	}

	public Company(int id, String name, String gSTno, String registerNum, List<Employe> listOfEmp) {
		super();
		this.id = id;
		this.name = name;
		this.GSTno = gSTno;
		this.registerNum = registerNum;
		this.listOfEmp = listOfEmp;
	}

	public Company() {
		super();
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", GSTno=" + GSTno + ", registerNum=" + registerNum
				+ ", listOfEmp=" + listOfEmp + "]";
	}
	
}
