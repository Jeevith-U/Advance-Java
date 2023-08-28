package com.tyss.food_app.userDao;

import com.tyss.food_app.entity.Branch;
import com.tyss.food_app.entity.Users;

public interface BranchDao {
	
	public Branch saveBranch(Branch branch) ;
	
	public Branch findBranch(int id) ;
	
	public Branch updateBranch(Branch branch) ;
	
	public boolean deleteBranch(int id) ;
	
	public Users luckyCustomer(Users users) ;
	
}
