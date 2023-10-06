package com.workingsapce.WorkSpace.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Floor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fid")
	@SequenceGenerator(name = "fid", initialValue =20, allocationSize = 25, sequenceName = "fseqid")
	private long floorId ;
	@OneToMany(cascade = CascadeType.ALL)
	private List<WorkSpace> workSpaces ;
	

}
