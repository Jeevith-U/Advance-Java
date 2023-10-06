package com.tyss.swagger.UserAppWithSwagger.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tyss.swagger.UserAppWithSwagger.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u where u.id = ?1")
	User findById(long id) ;

}
