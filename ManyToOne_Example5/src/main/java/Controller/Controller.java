package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Model.Brand;
public class Controller {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public void save(Brand brand) {
		
		entityTransaction.begin();
		entityManager.persist(brand);
	    entityManager.persist(brand.getServices());
		entityTransaction.commit(); 
	}
	
	public void findVehi(int id) {
		
		Brand brand = entityManager.find(Brand.class, id);
		
		System.out.println("Brand Id : "+brand.getId());
		System.out.println("Brand name : "+brand.getName());
		System.out.println("Brand Service : "+brand.getYears());
		
		System.out.println();
		System.out.println("Service Details ");
		System.out.println("Service Id : "+brand.getServices().getId());
		System.out.println("Service Name : "+brand.getServices().getName());
		System.out.println("Service Name : "+brand.getServices().getPincode());
	}
	
	public void updateBrand(int id, String name) {
		entityTransaction.begin();
		Brand brand = entityManager.find(Brand.class, id);
		brand.setName(name);
		entityManager.merge(brand) ;
		entityTransaction.commit();
	}
	
	public void deleteBrand(int id) {
		
		Brand brand = entityManager.find(Brand.class, id);
		
		entityTransaction.begin();
		entityManager.remove(brand);
		entityTransaction.commit();
	}
}
