package Controller;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.Persistence;

import Model.Company;
import Model.Product;
import edu.tyss.oneToMany_Example3.model.Customer;
import edu.tyss.oneToMany_Example3.model.Company;
import edu.tyss.oneToMany_Example3.model.Company;
import edu.tyss.oneToMany_Example3.model.Company;


public class Controller {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	public void save(Company company) {

		entityTransaction.begin();
		entityManager.persist(company);
		for (Product customer : company.getListOfProducts()) {
			entityManager.persist(customer);
		}
		entityTransaction.commit();
	}
	
	public void findAllProduct(int id) {

		Company company = entityManager.find(Company.class, id);

		for ( Product product : company.getListOfProducts()) {
			System.out.println("Customer ID : " + product.getId());
			System.out.println("Customer Name : " + product.getName());
			System.out.println("Customer phone Number : " + product.getPrice());
			System.out.println();
		}
		
	}
	
	public void updateCompany(int id, int cid, String name) {

		Company product = entityManager.find(Company.class, id);
		entityTransaction.begin();
		for ( Product product1 : product.getListOfProducts()) {

			if (product1.getId() == cid) {

				product1.setName(name);;
				entityManager.merge(product1);
			}
		}

		entityTransaction.commit();
	}
	
	public void deleteCustomer(int id, int cid) {

		Company company = entityManager.find(Company.class, id);
		Product delcustomer = null;
		entityTransaction.begin();
		Object customer;
		for ( Product customer1 : company.getListOfProducts()) {

//			if (customer1.getId() == cid) {
//				delcustomer = customer1;
//			}
		}

		company.getListOfProducts().remove(delcustomer);
		entityManager.remove(delcustomer);
		entityManager.merge(company);
		entityTransaction.commit();

	}
}
