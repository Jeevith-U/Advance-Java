package edu.tyss.userlogin.dao;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.tyss.userlogin.config.ConfigurationClass;
import edu.tyss.userlogin.dto.Users;

public class UserDao {
	
	
/*	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationClass.class);
	
	 EntityManagerFactory emf = (EntityManagerFactory)context.getBean("entityManagerFactory") ;
	 EntityManager em = (EntityManager)context.getBean("entityManager") ;
	 EntityTransaction et = (EntityTransaction)context.getBean("entityTransaction") ; */
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public void saveUsers(Users user) {
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
	}
	
	public List<Users> getAllUsers(){
		
		Query query = entityManager.createQuery("from Users") ;
		
		return query.getResultList() ;
	}
	
	public Users updateUser(Users users) {
		
		Users user = entityManager.find(Users.class, users.getId()) ;
		
		if (user !=  null) 
			return user ;
		
		return null ;
				
	}
	
	public Users findUser(int id) {
		Users user = entityManager.find(Users.class, id) ;
		if(user != null)
			return user ;
		
		return null ;
	}
}
