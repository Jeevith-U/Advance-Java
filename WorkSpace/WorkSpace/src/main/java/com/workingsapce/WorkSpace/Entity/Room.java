package com.workingsapce.WorkSpace.Entity;

import java.util.List;

import com.workingsapce.WorkSpace.Util.Type;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomid")
	@SequenceGenerator(name = "roomid", initialValue = 15450, allocationSize = 552, sequenceName = "roomseqid")
	private long roomId ;
	private Type type ;
	@OneToMany
	private List<Facilitie>facilities ;
}
