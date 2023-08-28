package edu.tyss.ManyToMany_Example1.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.ManyToMany_Example1.model.Account;
import edu.tyss.ManyToMany_Example1.model.Person;

public class Controller {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	
	public void save(Person person) {
		
		entityTransaction.begin();
		entityManager.persist(person);
		for(Account account : person.getAccounts()) {
			entityManager.persist(account);
		}
		
		entityTransaction.commit(); 
	}
	
	public void findAccount(int id) {
		
		Person person = entityManager.find(Person.class, id) ;
		System.out.println("Person Id :"+person.getId());
		System.out.println("Person Id :"+person.getName());
		System.out.println();
		System.out.println("Person Accounts :");
		for(Account account : person.getAccounts()) {
			System.out.println("Account ID :"+account.getId());
			System.out.println("Account ID :"+account.getAccoutType());
			System.out.println("Account ID :"+account.getBalance());
			System.out.println("Account ID :"+account.getBank());
			System.out.println();
			System.out.println("Account ID :");
		}
	}
	
	public void updateAccount(int id, int bid, double balance) {
		
		Person person = entityManager.find(Person.class, id) ;
		entityTransaction.begin();
		for(Account account : person.getAccounts()) {
			
			if (account.getId() == bid) {
				account.setBalance(balance);
				entityManager.merge(account) ;
			}
		}
		entityTransaction.commit();
	}
	
	public void deleteAccount(int id, int bid) {
		
		Person person = entityManager.find(Person.class, id) ;
		entityTransaction.begin();
		Account delAccount = null ;
		for(Account account : person.getAccounts()) {
			
			if (account.getId() == bid) {
				delAccount = account ;
			}
		}
		
		person.getAccounts().remove(delAccount);
		entityManager.remove(delAccount);
		entityManager.merge(person) ;
		entityTransaction.commit();
		
	}
}
