package com.tyss.spring_foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tyss.spring_foodapp.dao.UserDao;
import com.tyss.spring_foodapp.dto.Users;

@Component
@Scope(value = "prototype")
public class UserService {
	
	@Autowired
	private UserDao dao ;
	
	public void saveUser(Users users) {
		dao.saveUser(users) ;
	}
	
	public Users findUser(int id) {
		Users user = dao.findUser(id) ;
		return user ;
	}
	
	public Users updateUser(Users users) {
		Users user = dao.updateUser(users) ;
		return user ;
	}
	
	public boolean deleteUser(int id) {
		dao.deleteUsers(id) ;
		return true ;
	}

}
