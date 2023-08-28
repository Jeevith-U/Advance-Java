package edu.tyss.firstlevel_caching.Dao;

import java.util.Arrays ;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.firstlevel_caching.model.Products;
import edu.tyss.firstlevel_caching.model.Users;
import edu.tyss.firstlevel_caching.model.Users;

public class UserAndProductDao {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public static void main(String[] args) {
		
		UserAndProductDao dao = new UserAndProductDao() ;
		
		dao.save() ;
		
//		find() ;
	}

	public void save() {
	
		Users user = new Users() ;
		
		user.setEmail("jee@gmail.com");
		user.setPhno(987654567);
		
		Products product = new Products() ;
		product.setPrice(599);
		product.setUser(user);
		
		Products product2 = new Products() ;
		product2.setPrice(899);
		product2.setUser(user);
		
		List<Products> list = Arrays.asList(product,product2) ;
		
		user.setProductList(list);
		
		entityTransaction.begin(); 
		
		entityManager.persist(user);
		entityManager.persist(product);
		entityManager.persist(product2);
		
		entityTransaction.commit();
		
	}
}
