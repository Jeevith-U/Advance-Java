package edu.tyss.OneToOneExample2.Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.OneToOneExample2.model.IdCard;
import edu.tyss.OneToOneExample2.model.Person;

public class Controller {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public void savePerson(Person person) {
		
		IdCard card = person.getIdCard() ;
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(card);
		entityTransaction.commit();
	}
	
	public void findIdCard(int id) {
		
		Person person = entityManager.find(Person.class, id) ;
		
		System.out.println("Person Id : "+person.getId());
		System.out.println("Person Name : "+person.getName());
		System.out.println("Person Phone Number : "+person.getPhno());
		System.out.println();
		System.out.println("ID Card details :- ");
		System.out.println("ID : "+person.getIdCard().getId());
		System.out.println("ID : "+person.getIdCard().getName());
		System.out.println("ID : "+person.getIdCard().getIdType());
	}
	
	public void UpdateIdCard(int id , String name ) {
		
		Person person = entityManager.find(Person.class, id) ;
		entityTransaction.begin();
		person.getIdCard().setName(name);
		entityManager.merge(person) ;
		entityTransaction.commit(); 
	}
	
	public void deleteId(int id) {
		
		Person person = entityManager.find(Person.class, id) ;
		
		
		entityTransaction.begin();
		entityManager.remove(person);
		entityTransaction.commit();
		
	}
	
}
