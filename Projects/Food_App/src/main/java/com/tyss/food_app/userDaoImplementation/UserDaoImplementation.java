package com.tyss.food_app.userDaoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.food_app.entity.Users;
import com.tyss.food_app.userDao.UserDao;

public class UserDaoImplementation implements UserDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Users saveUser(Users user) {
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return null;
	}

	public Users findUser(int id) {

		return entityManager.find(Users.class, id);
	}

	public Users updateUser(Users user) {

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
		
        entityTransaction.begin();
		
		Users delUser = findUser(id) ;
		
		if (delUser != null) {
			
			entityManager.remove(delUser);
			
			entityTransaction.commit();
			
		}
		return false;
	}

	public String writeSuggetions(String suggestion) {

		return suggestion;
	}
	
	public boolean loginUser(String name, String password) {
		
		Query query = entityManager.createQuery("from Users u") ;
		
		List<Users> list = query.getResultList() ;
		
		for (Users users : list) {
			
			if ( users.getName().equalsIgnoreCase(name)&& users.getPassword().equals(password)) {
				
				return true ;
			}
		}
		return false ;
	}

}
