package edu.hibernate_assignment_dynamic.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Id_sequence")
	@SequenceGenerator(name = "Id_sequence", initialValue = 101, allocationSize = 100, sequenceName = "seq_bid_gen")
	@Column(name = "branch_id")
	private int id ;
	private String name ;
	private String address ;
	private long phno ;
	private String email ;
	
	@ManyToOne
	@JoinColumn(name = "branch_userInfo")
	private Users users ;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	
}
