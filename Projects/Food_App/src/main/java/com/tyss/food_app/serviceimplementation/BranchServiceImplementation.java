package com.tyss.food_app.serviceimplementation;

import java.util.List;

import javax.persistence.Query;

import com.tyss.food_app.entity.Branch;
import com.tyss.food_app.service.BranchService;
import com.tyss.food_app.userDaoImplementation.BranchDaoImplementation;
import com.tyss.food_app.util.EntityUtil;

public class BranchServiceImplementation implements BranchService{
	
	EntityUtil entityUtil = new EntityUtil() ;
	
	BranchDaoImplementation dao = new BranchDaoImplementation() ;

	
	public Branch saveBranchervice(Branch branch) {
		
		return dao.saveBranch(branch) ;
	}

	
	public Branch getBranchbyIdService(int id) {
		
		return dao.findBranch(id) ;
	}

	
	public Branch getBranchbyNamedService(String name) {
		
		Query query = entityUtil.manager.createQuery("select b from Branch b where b.name = ?1") ;
		query.setParameter(1, name) ;
		
		Branch branch = (Branch)query.getSingleResult() ;
		
		return branch;
		
		
	}

	
	public Branch updateBranchervice(Branch branch) {
		
		return dao.updateBranch(branch) ;
	}

	
	public boolean deleteBranchervice(int id) {
		
		return dao.deleteBranch(id) ;
	}

	
	public List<Branch> getAllBranchervice() {
		
		Query query = entityUtil.manager.createQuery("from Branch") ;
				
				return query.getResultList() ;
	}


	@Override
	public Branch getBranchEmailService(String email) {
		Query query = entityUtil.manager.createQuery("select b from Branch b where b.email = ?1") ;
		query.setParameter(1, email) ;
		
		Branch branch = (Branch)query.getSingleResult() ;
		
		return branch;
	}


	@Override
	public Branch getBranchbyPhoneNumberService(long phno) {
		Query query = entityUtil.manager.createQuery("select b from Branch b where b.phno = ?1") ;
		query.setParameter(1, phno) ;
		
		Branch branch = (Branch)query.getSingleResult() ;
		
		return branch;
	}

}
