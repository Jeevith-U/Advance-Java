package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Model.User;
import Model.UserProduct;

public class UserAndProductDao {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public static void main(String[] args) {
		
		save() ;
	}
	
	public static void save() {
		
		User user = new User() ;
		
		user.setId(101);
		user.setName("Jeevith");
		
		UserProduct product = new UserProduct() ;
		product.setPid(10122);
		product.setPname("phone");
		product.setPrice(29000);
		
		user.setProduct(product);
		
		entityTransaction.begin();
		entityManager.merge(user) ;
		entityManager.merge(product) ;
		entityTransaction.commit();
		
		System.out.println("Added..");
	}
}
