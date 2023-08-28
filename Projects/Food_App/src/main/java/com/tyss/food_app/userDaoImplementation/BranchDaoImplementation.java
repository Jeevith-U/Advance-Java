package com.tyss.food_app.userDaoImplementation;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.food_app.entity.Branch;
import com.tyss.food_app.entity.Users;
import com.tyss.food_app.userDao.BranchDao;

public class BranchDaoImplementation implements BranchDao{

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Branch saveBranch(Branch branch) {
		
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
		
		Random id = new Random() ;
		int num = id.nextInt(100) ;
		
		Users luckyUser = entityManager.find(Users.class, id) ;
		
		if (luckyUser != null) {
			return luckyUser ;
		}
		
		return null;
	}

}
