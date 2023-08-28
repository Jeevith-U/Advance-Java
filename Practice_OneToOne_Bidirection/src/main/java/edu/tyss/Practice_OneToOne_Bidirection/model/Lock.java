package edu.tyss.Practice_OneToOne_Bidirection.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Lock {
	
	@Id
	@Column(name = "Lock_Id")
	private int id ;
	@Column(nullable = false) 
	private String name ;
	
	@OneToOne
	private Key key ;

	public int getLock_Id() {
		return id;
	}

	public void setLock_Id(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Lock [id=" + id + ", name=" + name + ", key=" + key + "]";
	}
	
}
