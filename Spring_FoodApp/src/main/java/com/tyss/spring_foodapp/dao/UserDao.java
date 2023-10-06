package com.tyss.spring_foodapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tyss.spring_foodapp.dto.Users;

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

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		Users updateUser = findUser(user.getId());

		System.out.println(user.getId());

		if (updateUser != null) {

			user.setEmail(updateUser.getEmail());

			entityManager.merge(user);

			entityTransaction.commit();

			return updateUser;

		}

		return null;
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
}
