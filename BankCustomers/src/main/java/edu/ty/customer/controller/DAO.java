package edu.ty.customer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.ty.bankaccount.model.BankAccount;
import edu.ty.customer.model.Customer;

public class DAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void createUser() {
		Customer customer=new Customer();
		customer.setId(2);
		customer.setAge(24);
		customer.setName("gagan");
		customer.setPhone_number(98795225l);
		customer.setEmail("gagan@gmail.com");
		BankAccount account1 = new BankAccount();
		account1.setId(104);
		account1.setAccountNumber("14525225");
		account1.setBankName("hdfc");
		account1.setIfsc("dsxyx");
		BankAccount account2 = entityManager.find(BankAccount.class, 101);
		
		
		List<BankAccount> accounts=new ArrayList<BankAccount>();
		accounts.add(account1);
		accounts.add(account2);
		customer.setAccounts(accounts);
		entityTransaction.begin();
		entityManager.persist(customer);
		entityManager.persist(account1);
		entityTransaction.commit();

	}

	public Customer findCustomerById(int id) {
		return entityManager.find(Customer.class, id);
	}

	public void updateCustomerNameById(int id, String name) {
        Customer customer=findCustomerById(id);
		if (customer != null) {
			customer.setName(name);
			entityTransaction.begin();
			entityManager.merge(customer);
			entityTransaction.commit();
			System.out.println("updated");
		} else {
			System.out.println("no record found");
		}

	}

	public void deletePerson(int id) {
		Customer customer=findCustomerById(id);
		if (customer != null) {
			entityTransaction.begin();
			entityManager.remove(customer);
			entityTransaction.commit();
			System.out.println("deleted");
		} else {
			System.out.println("no record found");
		}
	}
}
