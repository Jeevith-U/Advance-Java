package com.tyss.food_app.test;

import com.tyss.food_app.entity.Branch;
import com.tyss.food_app.userDaoImplementation.BranchDaoImplementation;

public class BranchController {
	
	public static void main(String[] args) {
		
		BranchDaoImplementation dao = new BranchDaoImplementation() ;
		
//		Branch branch = new Branch() ;
//		branch.setAddress("Near Amrut Gobi center");
//		branch.setEmail("mysore@gmail.com");
//		branch.setName("Mysore");
//		branch.setPhno(163545143);
//		
//		dao.saveBranch(branch) ;
		
//		Branch branch1 = new Branch() ;
//		branch1.setEmail("banglore@gmail.com");
//		branch1.setAddress("jayanagara infornt of Indiqube");
//		branch1.setName("banglore");
//		branch1.setPhno(83482742);
//		
//		dao.saveBranch(branch1) ;
		
		Branch branch = dao.findBranch(2) ;
		System.out.println(branch);
		
		branch.setPhno(999999999);
		branch.setEmail("-------@gmeil.com");
		
		dao.updateBranch(branch) ;
		
		dao.deleteBranch(2) ;
		
		
	}

}
