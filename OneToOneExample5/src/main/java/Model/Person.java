package Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	
	@Id
	private int id ;
	private String name ;
	private int age ;
	
	@OneToOne
	private VoterId voterId ;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public VoterId getVoterId() {
		return voterId;
	}

	public void setVoterId(VoterId voterId) {
		this.voterId = voterId;
	}
	
}
