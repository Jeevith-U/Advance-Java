package com.tyss.springfoodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tyss.springfoodapp.dto.Users;

@Component
@Scope(value = "prototype")
public class UserDao {

	@Autowired
	private EntityManager entityManager;

	public Users saveUser(Users user) {

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return null;
	}

	public Users findUser(int id) {

		return entityManager.find(Users.class, id);
	}

	public Users updateUser(Users user) {
		
//		System.out.println("Service Begin");
//		
//		System.out.println(user.getId());
//
		EntityTransaction entityTransaction = entityManager.getTransaction();
//
//
//		Users updateUser = findUser(user.getId());
//		
//		System.out.println("Update User");
//		
//		System.out.println(updateUser);
//
//		if (updateUser != null) {
//			
//			System.out.println("Enterd the Condition Checking");
			
			entityTransaction.begin();

//			updateUser.setName(user.getName());
//			updateUser.setEmail(user.getEmail());
//			updateUser.setPassword(user.getEmail());
			
			entityManager.merge(user) ;
//			System.out.println(updateUser);
			entityTransaction.commit();
//	}

		return user;
	}

	public boolean deleteUsers(int id) {

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		Users delUser = findUser(id);

		if (delUser != null) {

			entityManager.remove(delUser);

			entityTransaction.commit();

		}
		return false;
	}

	public Users findUserByEmail(String email, String password) {

		Query query = entityManager.createQuery("select s from Users s where s.email = ?1 and s.password=?2");

		query.setParameter(1, email);
		query.setParameter(2, password);

//		 Users user = (Users)query.getSingleResult() ;
//		 
//		 if (user != null && user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(passwors)) {
//			
//			 return user ;
//		}
//		
//		return null ;

		List<Users> users = query.getResultList();
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	public List<Users> findAllUser() {

		Query query = entityManager.createQuery("from Users u");
		return query.getResultList();
	}
	
	public List<Users> findAllStaff() {
		
		Query query = entityManager.createQuery("select s from Users s where s.role=?1") ;
		query.setParameter(1, "STAFF") ;
		return query.getResultList() ;
	}
}
