package Model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AccountId implements Serializable{
	
	private int id;
	private String email ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
