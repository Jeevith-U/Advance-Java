package ManyToMany_Example2.Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ManyToMany_Example2.model.Party;
import ManyToMany_Example2.model.Voter;

public class Controller {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public void save(Party party) {
		entityTransaction.begin();
		entityManager.persist(party);
		for( Voter voter : party.getList()) {
			entityManager.persist(voter);
		}
		entityTransaction.commit(); 
	}
	
	public void findParty(int id) {
		
		Party party = entityManager.find(Party.class, id) ;
		System.out.println(party);
	}
	
	public void updateParty(int id, String name) {
		
		Party party = entityManager.find(Party.class, id) ;
		
		entityTransaction.begin();
		party.setName(name);
		entityManager.merge(party);
		entityTransaction.commit();
	}
	
	public void deleteVoter(int id, int pid) {
		
		entityTransaction.begin();
		Party party = entityManager.find(Party.class, id) ;
		Voter delVoter = null ;
		for( Voter voter : party.getList()) {
			delVoter = voter ;
		}
		
		party.getList().remove(delVoter) ;
		entityManager.remove(delVoter);
		entityManager.merge(party) ;
		entityTransaction.commit();
	}
}
