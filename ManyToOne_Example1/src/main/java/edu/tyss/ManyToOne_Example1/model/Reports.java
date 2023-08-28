package edu.tyss.ManyToOne_Example1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reports {
	
	@Id
	private int id;
	private String name ;
	private String reportName;
	
	@ManyToOne
	private Paticent paticent ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public Paticent getPaticent() {
		return paticent;
	}

	public void setPaticent(Paticent paticent) {
		this.paticent = paticent;
	}
	
}
