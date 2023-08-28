package edu.tyss.aadharandperson.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.tyss.aadharandperson.model.Aadhar;
import edu.tyss.aadharandperson.model.Person;

public class AadharAndPersonController {
	
	
	public void savePerson(Person person, Aadhar aadhar) {
		
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
		
		 EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		
		 EntityTransaction entityTransaction = entityManager.getTransaction() ;
		 
		 entityTransaction.begin();
		 entityManager.persist(person);
		 entityManager.persist(aadhar);
		 entityTransaction.commit();
	}
	
	public Person findPerson(int id) {
		
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
		
		 EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		
		 EntityTransaction entityTransaction = entityManager.getTransaction() ;
		 
		 Query query = entityManager.createQuery("SELECT s FROM Person s") ;
		 
		 List<Person> persons = query.getResultList() ;
			
			for (Person person : persons) {
				
				if (person.getId() == id) {
					
					return person ;
				}
			}
			return null;
	}
	
	public void UpdatePerson(int id, long phno) {
		
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
			
		 EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		
		 EntityTransaction entityTransaction = entityManager.getTransaction() ;
		 
		 entityTransaction.begin(); 
		 Person result = entityManager.find(Person.class, id) ;
		 result.setPhno(phno);
		 entityManager.merge(result) ;
		 entityTransaction.commit();
	}
	
	public void deletePerson(int id) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
		
		 EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		
		 EntityTransaction entityTransaction = entityManager.getTransaction() ;
		 
		 entityTransaction.begin();
		 Person delResult = entityManager.find(Person.class, id) ;
		 entityManager.remove(delResult);
		 entityTransaction.commit();
	}
	
	public String findPersonByAadharNumber(long aadharNumber) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
		
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		
		Query query = entityManager.createQuery("select s from Person ") ;
		
		List<Person> result = query.getResultList() ;
		
		for (Person person : result) {
			
			if (person.getAadhar().getAadharNumber() == aadharNumber) {
				
				return person.getName() ;
			}
		}
		return null;
	}
}
