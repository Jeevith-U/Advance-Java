package ManyToMany_Example2.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Party {
	
	@Id
	private int id;
	private String name ;
	
	@ManyToMany
	private List<Voter> list ;

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

	public List<Voter> getList() {
		return list;
	}

	public void setList(List<Voter> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Party [id=" + id + ", name=" + name + ", list=" + list + "]";
	}
	
	
	
}
