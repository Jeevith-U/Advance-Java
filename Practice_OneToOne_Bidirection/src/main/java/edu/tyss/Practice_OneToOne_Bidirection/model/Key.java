package edu.tyss.Practice_OneToOne_Bidirection.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Key {
	
	@Id
	@Column(name = "Key_Id")
	private int id ;
	private String name ;
	@Column(unique = true)
	private Long key_num ;
	
	@OneToOne
	private Lock lock ;

	public int getKey_Id() {
		return id;
	}

	public void setKey_Id(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getKey_num() {
		return key_num;
	}

	public void setKey_num(long i) {
		this.key_num = i;
	}

	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}

	@Override
	public String toString() {
		return "Key [id=" + id + ", name=" + name + ", key_num=" + key_num + ", lock=" + lock + "]";
	}
	
}
