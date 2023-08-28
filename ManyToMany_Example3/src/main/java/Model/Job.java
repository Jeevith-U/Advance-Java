package Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Job {
	
	@Id
	private int id ;
	private String designation ;
	private double sal ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", designation=" + designation + ", sal=" + sal + "]";
	}
	
}
