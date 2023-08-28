package Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Person {
	
	@Id
	private int id;
	private String name ;
	@ManyToMany
	private List<Job> list ;
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
	public List<Job> getList() {
		return list;
	}
	public void setList(List<Job> list) {
		this.list = list;
	}
	
}
