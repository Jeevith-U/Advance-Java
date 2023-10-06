package com.workingsapce.WorkSpace.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Building {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bid")
	@SequenceGenerator(name = "bid", initialValue = 10, allocationSize = 10, sequenceName = "buiseqid")
	private long buildingId ;
	private String buildingName ;
	private String area ;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address ;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Floor> floors ;
	
}
