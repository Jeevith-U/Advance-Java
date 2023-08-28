package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Model.Person;
import Model.VoterId;

public class Controller {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public void savevoterIdDetails(Person person) {
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(person.getVoterId());
		entityTransaction.commit();
	}
	
public void findPersonDetails(int num) {
		
		Person person = entityManager.find(Person.class, num) ;
		System.out.println("Person Id : "+person.getId());
		System.out.println("Person Id : "+person.getName());
		System.out.println("Person Id : "+person.getAge());
		
		System.out.println();
		System.out.println("Person Details :-");
		System.out.println(person.getVoterId().getCardNum());
		System.out.println(person.getVoterId().getState());
		
	}
	
	public void updatePersonDetails(int Num, String state) {
		
		Person person = entityManager.find(Person.class, Num) ;
		
		entityTransaction.begin();
		person.getVoterId().setState(state);
		entityManager.merge(person);
		entityTransaction.commit();
	}
	
	public void deletePerson(int num) {
		
		Person person = entityManager.find(Person.class, num) ;
		
		entityTransaction.begin();
		entityManager.remove(person);
		entityTransaction.commit();
	}
}
