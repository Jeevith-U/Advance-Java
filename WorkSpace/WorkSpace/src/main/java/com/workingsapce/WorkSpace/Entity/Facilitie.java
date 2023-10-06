package com.workingsapce.WorkSpace.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Facilitie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faceid")
	@SequenceGenerator(name = "faceid", initialValue = 15450, allocationSize = 552, sequenceName = "faceseqid")
	private long facilitieId ;
	private String facilityName ;
	
}
