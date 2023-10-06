package com.tyss.springfoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tyss.springfoodapp.dao.UserDao;
import com.tyss.springfoodapp.dto.Users;


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
		System.out.println("From Service class");
		Users user = dao.updateUser(users) ;
		return user ;
	}
	
	public boolean deleteUser(int id) {
		dao.deleteUsers(id) ;
		return true ;
	}
	
	public Users findUserByEmailAndPassword(String email, String password) {
		
		return dao.findUserByEmail(email, password) ;
	}
	
	public List<Users> findAllUSer(){
		return dao.findAllUser() ;
	}
	
	public List<Users> findAllStaff(){
		return dao.findAllStaff() ;
	}
	

}
