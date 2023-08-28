package Model;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Cacheable
public class Hospital {
	
	@Id
	private int id ;
	private String name ;
	private String Hospital_Number ;
	
	@OneToMany(mappedBy = "hospital")
	private List<Paticent> listOfPaticents ;
	
	public List<Paticent> getListOfPaticents() {
		return listOfPaticents;
	}
	public void setListOfPaticents(List<Paticent> listOfPaticents) {
		this.listOfPaticents = listOfPaticents;
	}
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
	public String getHospital_Number() {
		return Hospital_Number;
	}
	public void setHospital_Number(String hospital_Number) {
		Hospital_Number = hospital_Number;
	}
	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", Hospital_Number=" + Hospital_Number + ", listOfPaticents="
				+ listOfPaticents + "]";
	}
	
}
