package com.workingsapce.WorkSpace.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class CoworkSpace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name ;
	private String city ;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address ;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Building> buildings ;
}
