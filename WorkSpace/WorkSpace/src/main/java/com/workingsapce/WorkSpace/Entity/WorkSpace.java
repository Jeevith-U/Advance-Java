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

@Entity
@Data
public class WorkSpace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workid")
	@SequenceGenerator(name = "workid", initialValue = 150, allocationSize = 50, sequenceName = "workseqid")
	private long workspaceId ;
	@OneToOne(cascade = CascadeType.ALL)
	private Company company ;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Room> rooms ;
}
