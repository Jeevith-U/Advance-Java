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
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comid")
	@SequenceGenerator(name = "comid", initialValue = 1550, allocationSize = 250, sequenceName = "comseqid")
	private long companyId ;
	private String companyName ;
	private long numberOfEmployee ;
	private String companyEmail ;
	private long companyPhoneNUmber ;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Room> roomList ;
}
