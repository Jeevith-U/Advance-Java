package edu.tyss.mto_otm_bideirection.Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.mto_otm_bideirection.model.Account;
import edu.tyss.mto_otm_bideirection.model.Bank;

public class Controller {
	
	    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
		static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		static EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		
		public void save(Bank bank) {
			
			entityTransaction.begin();
			entityManager.persist(bank);
			for(Account account : bank.getAccounts()) {
			entityManager.persist(account);
			}
			entityTransaction.commit();
		}
		
		public Bank findAccountsUsingBank(int id) {
			
			Bank bank = entityManager.find(Bank.class, id) ;
			
			if (bank.getId() == id) {
				return bank ;
			}
			
			System.out.println("Bank Id :"+bank.getId());
			System.out.println("Bank Name :"+bank.getName());
			System.out.println();
			System.out.println("Accounts:-");
			List<Account> accounts = bank.getAccounts() ;
			for (Account account : accounts) {
				System.out.println("Account Id : "+account.getAccountNumber());
				System.out.println("Account Id : "+account.getAccountType());
				System.out.println("Account Id : "+account.getPrice());
			}
			return null ;
		}
		
		public Account findBankUsingAccount(int id) {
			
			  Account account = entityManager.find(Account.class, id) ;
			  
			  return account ;
			
		}
		public void updateBankDetailsUsingAccount(int aid, String name) {
			Account account = entityManager.find(Account.class, aid) ;
			entityTransaction.begin();
			account.getBank().setName(name);
			entityManager.merge(account) ;
			entityTransaction.commit();
		}
		
		public void updateAccountDetailsUsingBank(int bid, int aid, double balance) {
			
			Bank bank = entityManager.find(Bank.class, bid) ;
			entityTransaction.begin();
			List<Account> accounts = bank.getAccounts() ;
			for (Account account : accounts) {
				if (account.getAccountNumber() == aid) {
					account.setPrice(balance);
					entityManager.merge(bank) ;
				}
			}
			entityTransaction.commit();
		}
		
		public void deleteAccountUsingBank(int bid, int aid) {
			
			Bank bank = entityManager.find(Bank.class, bid) ;
			entityTransaction.begin();
			Account delaccount = null ;
			List<Account> accounts = bank.getAccounts() ;
			for (Account account : accounts) {
				if (account.getAccountNumber() == aid) {
					delaccount = account ;
				}
			}
			accounts.remove(delaccount) ;
			entityManager.remove(delaccount);
			entityManager.merge(bank) ;
			entityTransaction.commit(); 
		}
	
}
