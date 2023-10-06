package com.workingsapce.WorkSpace.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userid")
	@SequenceGenerator(name = "userid", initialValue = 12250, allocationSize = 53, sequenceName = "userseqid")
	private int userID ;
	private String name ;
	@Column(unique = true)
	private String email ;
	@Column(unique = true)
	private long phoneNumber ;
	private String address ;
	
}
