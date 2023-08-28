package Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VoterId {
	
	@Id
	private int cardNum ;
	private String state ;
	public int getCardNum() {
		return cardNum;
	}
	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
