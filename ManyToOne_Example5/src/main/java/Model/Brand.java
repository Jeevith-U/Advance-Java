package Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Brand {
	
	@Id
	private int id;
	private String name ;
	private int years ;
	
	@ManyToOne
	private Service services ;

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

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	

	public Service getServices() {
		return services;
	}

	public void setServices(Service services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", years=" + years + ", services=" + services + "]";
	}
	
	
}
