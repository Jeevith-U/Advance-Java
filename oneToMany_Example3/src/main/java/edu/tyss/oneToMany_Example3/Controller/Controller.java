package edu.tyss.oneToMany_Example3.Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.oneToMany_Example3.model.Customer;
import edu.tyss.oneToMany_Example3.model.Mall;

public class Controller {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	public void save(Mall mall) {

		entityTransaction.begin();
		entityManager.persist(mall);
		for (Customer customer : mall.getCustomers()) {
			entityManager.persist(customer);
		}
		entityTransaction.commit();
	}

	public void findAllCustomer(int id) {

		Mall customers = entityManager.find(Mall.class, id);

		for (Customer customer : customers.getCustomers()) {
			System.out.println("Customer ID : " + customer.getId());
			System.out.println("Customer Name : " + customer.getName());
			System.out.println("Customer phone Number : " + customer.getPhno());
			System.out.println();
		}
	}

	public void updateCustomerDetail(int id, int cid, long phno) {

		Mall customers = entityManager.find(Mall.class, id);
		entityTransaction.begin();
		for (Customer customer : customers.getCustomers()) {

			if (customer.getId() == cid) {

				customer.setPhno(phno);
				entityManager.merge(customer);
			}
		}

		entityTransaction.commit();
	}

	public void deleteCustomer(int id, int cid) {

		Mall customers = entityManager.find(Mall.class, id);
		Customer delcustomer = null;
		entityTransaction.begin();
		for (Customer customer : customers.getCustomers()) {

			if (customer.getId() == cid) {
				delcustomer = customer;
			}
		}

		customers.getCustomers().remove(delcustomer);
		entityManager.remove(delcustomer);
		entityManager.merge(customers);
		entityTransaction.commit();

	}
}
