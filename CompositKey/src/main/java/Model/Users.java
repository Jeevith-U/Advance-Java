package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Users {
	
	@EmbeddedId
	AccountId id ;
	private String name ;
	private int age ;
	public AccountId getId() {
		return id;
	}
	public void setId(AccountId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
