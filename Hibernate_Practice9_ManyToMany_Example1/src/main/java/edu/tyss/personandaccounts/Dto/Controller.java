package edu.tyss.personandaccounts.Dto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.personandaccounts.model.Person;
import edu.tyss.personandaccounts.model.SocialMediaAccount;

public class Controller {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public void addPersonAndAccounts(Person person) {
		List<SocialMediaAccount> listOfAccounts = person.getAccounts() ;
		entityTransaction.begin();
		entityManager.persist(person);
		for (SocialMediaAccount socialMediaAccount : listOfAccounts) {
			
			entityManager.persist(socialMediaAccount);
		}
		entityTransaction.commit();
	}
	
	public SocialMediaAccount findAccountById(int id) {
		
		SocialMediaAccount account = entityManager.find(SocialMediaAccount.class, id) ;
		
		return account ;
		
	}
	
	public void updateAccountName(int id, int followers) {
		
		SocialMediaAccount account = entityManager.find(SocialMediaAccount.class, id) ;
		
		entityTransaction.begin();
		account.setFollowers(followers);
		entityManager.merge(account) ;
		entityTransaction.commit();
	}
	                       //232023     // 65202
	public void deletAccount(int id, int accountId) {
		
		Person person = entityManager.find(Person.class, id) ;
		
		List<SocialMediaAccount> list = person.getAccounts() ;
		
		SocialMediaAccount delAccount = null ;
		for (SocialMediaAccount socialMediaAccount : list) {
			
			if (socialMediaAccount.getId() == accountId) {
				
				delAccount = socialMediaAccount ;
			}
		}
		
		entityTransaction.begin();
		list.remove(delAccount) ;
		entityManager.remove(delAccount);
		entityManager.merge(person) ;
		entityTransaction.commit();
		
	}
}
