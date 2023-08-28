package edu.tyss.onetomany.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.tyss.onetomany.model.Account;
import edu.tyss.onetomany.model.Bank;

public class TestSaveBank {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public static void main(String[] args) {
		
		TestSaveBank testSaveBank = new TestSaveBank() ;
		
//		testSaveBank.saveBank() ;
		
//		testSaveBank.findBank(3302) ;
		
//		testSaveBank.findAllBankDetails() ;
		
//		testSaveBank.UpdateBank
	}
	
	/*
	 * to retrieve all the bank details 
	 */
	
	private void findAllBankDetails() {
		
		Query query = entityManager.createQuery("Select s from Bank s") ;
		List<Bank> listOfBank = query.getResultList() ;
		
		for (Bank bank : listOfBank) {
			
			System.out.println("Bank ID : "+bank.getId());
			 System.out.println("Bank Name : "+bank.getName());
			 System.out.println("Bank IFSC : "+bank.getIfsc());
			 
			 List<Account> accounts = bank.getAccounts() ;
				
				System.out.println("The bank Contains The fallowing accounts : -");
				for (Account account : accounts) {
					System.out.println("********************************************");
					System.out.println("Account Id : "+ account.getId());
					System.out.println("Account Number : "+ account.getNumber());
					System.out.println("Account Balance : "+ account.getBalance());
					
				}
		}
		
	}

	/*
	 * to retrive a perticular record 
	 */
	private void findBank(int i) {
		
		 Bank bank = entityManager.find(Bank.class, 3302 ) ;
		 System.out.println("Bank ID : "+bank.getId());
		 System.out.println("Bank Name : "+bank.getName());
		 System.out.println("Bank IFSC : "+bank.getIfsc());
		List<Account> accounts = bank.getAccounts() ;
		
		System.out.println("The bank Contains The fallowing accounts : -");
		for (Account account : accounts) {
			System.out.println("********************************************");
			System.out.println("Account Id : "+ account.getId());
			System.out.println("Account Number : "+ account.getNumber());
			System.out.println("Account Balance : "+ account.getBalance());
			
		}
	}

	private void saveBank() {
		
		Bank hdfc = new Bank() ;
		hdfc.setId(3302);
		hdfc.setName("HDFC");
		hdfc.setIfsc("HDFC110033");
		
		List<Account> listOfAccount = new ArrayList<Account>() ;
		
		Account account4 = new Account() ;
		account4.setId(3002);
		account4.setNumber(1100333002);
		account4.setBalance(22656234);
		
		Account account5 = new Account() ;
		account5.setId(3202) ;
		account5.setNumber(100333202);
		account5.setBalance(975435623);
		
		Account account6 = new Account() ;
		account6.setId(3302);
		account6.setNumber(1100333302);
		account6.setBalance(45234524);
		
		listOfAccount.add(account4);
		listOfAccount.add(account5) ;
		listOfAccount.add(account6) ;
		
		hdfc.setAccounts(listOfAccount);
		
		entityTransaction.begin();
		entityManager.persist(hdfc);
		entityManager.persist(account4);
		entityManager.persist(account5);
		entityManager.persist(account6);
		entityTransaction.commit();
		
		System.out.println("saved....!");
		
	}
}
