package com.tyss.food_app.service;

import java.util.List;

import com.tyss.food_app.entity.Branch;

public interface BranchService {
	
	public Branch saveBranchervice (Branch branch) ;
	public Branch getBranchbyIdService (int id) ;
	public Branch getBranchbyNamedService (String name) ;
	public Branch getBranchEmailService (String email) ;
	public Branch getBranchbyPhoneNumberService (long phno) ;
	public Branch updateBranchervice (Branch branch) ;
	public boolean deleteBranchervice (int id) ;
	public List<Branch> getAllBranchervice () ;

}
