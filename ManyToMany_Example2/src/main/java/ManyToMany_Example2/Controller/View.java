package ManyToMany_Example2.Controller;

import java.util.Arrays;
import java.util.List;

import ManyToMany_Example2.model.Party;
import ManyToMany_Example2.model.Voter;

public class View {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		View view = new View() ;
		
//		view.create(controller) ;
		
//		controller.findParty(763);
		
//		controller.updateParty(763, "BBjp");
		
		controller.deleteVoter(763, 673);
		
	}

	private void create(Controller controller) {
		
		Party party = new Party() ;
		
		party.setId(763);
		party.setName("BJP");
		
		Voter voter = new Voter() ;
		
		voter.setId(673);
		voter.setName("Jee");
		voter.setLocation("Mysore");
		
		Voter voter2 = new Voter() ;
		voter2.setId(723);
		voter2.setName("nish");
		voter2.setLocation("Mandya");
		
		List<Voter> list = Arrays.asList(voter, voter2) ;
		
		party.setList(list);
		controller.save(party);
		System.out.println("Added..");
	}
}
