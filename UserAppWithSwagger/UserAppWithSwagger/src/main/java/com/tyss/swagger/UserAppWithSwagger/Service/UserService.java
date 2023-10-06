package com.tyss.swagger.UserAppWithSwagger.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.swagger.UserAppWithSwagger.Entity.User;
import com.tyss.swagger.UserAppWithSwagger.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo ;
	
	public void saveUser(User user) {
		repo.save(user) ;
	}
	
	public User findById(long id) {
		 return repo.findById(id) ;
	}
}
