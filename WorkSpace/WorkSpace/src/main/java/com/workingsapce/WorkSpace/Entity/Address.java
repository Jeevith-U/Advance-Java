package com.workingsapce.WorkSpace.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	@SequenceGenerator(name = "id", initialValue = 1202, allocationSize = 250, sequenceName = "seqId")
	private int StreetNumber ;
	private String streetName ;
	private int area ;
	private String state ;
	private int pincode ;
	@OneToOne
	private CoworkSpace coworkSpace ;
	@OneToOne
	private Building building ;
	
}
