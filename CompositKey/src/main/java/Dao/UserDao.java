package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Model.AccountId;
import Model.Users;

public class UserDao {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public static void main(String[] args) {
		
		save() ;
	}
	
	public static void save() {
		
		AccountId id = new AccountId() ;
		
		id.setId(101);
		id.setEmail("jee@gmail.com");
		
		Users user = new Users() ;
		
		user.setAge(22);
		user.setId(id);
		user.setName("Sanjee");
		
		entityTransaction.begin(); 
		entityManager.persist(user);
		entityTransaction.commit();
		System.out.println("Added.");
	}
}
