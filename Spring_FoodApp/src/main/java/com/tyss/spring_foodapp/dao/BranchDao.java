package com.tyss.spring_foodapp.dao;

import java.util.Random;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tyss.spring_foodapp.dto.Branch;
import com.tyss.spring_foodapp.dto.Users;

@Component
@Scope(value = "prototype")
public class BranchDao {

	
	@Autowired
	private EntityManager entityManager ;
	
	public Branch saveBranch(Branch branch) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		entityTransaction.begin();
		entityManager.persist(branch);
		entityTransaction.commit();
		
		return branch;
	}

	
	public Branch findBranch(int id) {
		
		Branch branch = entityManager.find(Branch.class, id) ;
		
		if (branch != null) 
			return branch ;
		
		return null;
	}

	
	public Branch updateBranch(Branch branch) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		entityTransaction.begin();
		
		Branch updateBranch = findBranch(branch.getId()) ;
		
		if (updateBranch != null) {
			
			updateBranch.setName(branch.getName());
			updateBranch.setPhno(branch.getPhno());
			updateBranch.setEmail(branch.getEmail());
			
			entityManager.merge(updateBranch) ;
			entityTransaction.commit();
			return branch ;
		}
		
		return null;
	}

	
	public boolean deleteBranch(int id) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		entityTransaction.begin();
		
		Branch delBranch = findBranch(id) ;
		
		if (delBranch != null) {
			
			entityManager.remove(delBranch);
			entityTransaction.commit();
			return true ;
		}
		return false;
	}

	
	public Users luckyCustomer(Users users) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		Random id = new Random() ;
		int num = id.nextInt(100) ;
		
		Users luckyUser = entityManager.find(Users.class, id) ;
		
		if (luckyUser != null) {
			return luckyUser ;
		}
		
		return null;
	}

}
