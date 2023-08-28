package com.tyss.food_app.serviceimplementation;

import javax.persistence.Query;

import com.tyss.food_app.entity.Branch;
import com.tyss.food_app.entity.FoodOder;
import com.tyss.food_app.entity.Menu;
import com.tyss.food_app.entity.Users;
import com.tyss.food_app.service.UserService;
import com.tyss.food_app.userDaoImplementation.UserDaoImplementation;
import com.tyss.food_app.util.EntityUtil;

public class UserServiceImplementation implements UserService{
	
	EntityUtil entity = new EntityUtil() ;
	
	UserDaoImplementation dao = new UserDaoImplementation() ;
	
	public Users saveUserService(Users users) {
		
		dao.saveUser(users) ;
		
		return users;
	}

	
	public Users getUserbyIdService(int id) {
		
		return dao.findUser(id) ;
		
	}

	
	public Users loginService(String name, String password) {
		
        Query query = entity.manager.createQuery("select u from Users u where u.name=?1 and u.password = ?2") ;
		
		query.setParameter(1, name) ;
		query.setParameter(2, password) ;
		
		 Users user = (Users)query.getSingleResult() ;
		return user;
	}

	public Users getUserbyUserNamedService(String name, String password) {
		 Query query = entity.manager.createQuery("select u from Users u where u.name=?1 and u.password = ?2") ;
			
			query.setParameter(1, name) ;
			query.setParameter(2, password) ;
			
			 Users user = (Users)query.getSingleResult() ;
			return user;
	}


	
	public Users getUserbyEmailService(String email, String password) {
     
		Query query = entity.manager.createQuery("select u from Users u where u.email=?1 and u.password = ?2") ;
		
		query.setParameter(1, email) ;
		query.setParameter(2, password) ;
		
		 Users user = (Users)query.getSingleResult() ;
		return user;
	}


	public Users updateUserService(Users users) {
		
		return dao.updateUser(users) ;
	}

	public boolean deleteUSerService(int users) {
		
		return dao.deleteUsers(users) ;
	}

	public Users getUserByBranchId(int id) {
		
		return entity.manager.find(Branch.class, id).getUsers() ;
		
	}

	public Users getUserByMenuId(int id) {
		
		return entity.manager.find(Menu.class, id).getUsers() ;
	}

	public Users getUserByFoodOrderId(int id) {
		
		return entity.manager.find(FoodOder.class, id).getUsers() ;
	}
}
