package edu.tyss.oneToMany_Example4.Dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.oneToMany_Example4.model.Netflix;
import edu.tyss.oneToMany_Example4.model.Users;

public class Controller {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	public void save(Netflix netflix) {

		entityTransaction.begin();
		entityManager.persist(netflix);
		for (Users user : netflix.getUsers()) {
			entityManager.persist(user);
		}
		entityTransaction.commit();
	}

	public void findAllUser(int id) {

		Netflix netflix = entityManager.find(Netflix.class, id);

		for (Users user : netflix.getUsers()) {
			System.out.println("User Id : " + user.getId());
			System.out.println("User Number : " + user.getUserNuber());
			System.out.println("User device : " + user.getUserDevice());
			System.out.println();
		}
	}

	public void updateUser(int id, int uid, String device) {

		Netflix netflix = entityManager.find(Netflix.class, id);

		entityTransaction.begin();
		for (Users user : netflix.getUsers()) {
			if (user.getId() == uid)
				user.setUserDevice(device);
			entityManager.merge(netflix) ;
		}
		
		entityTransaction.commit();
	}
	
	public void deleteUser(int id, int uid) {
		
		Netflix netflix = entityManager.find(Netflix.class, id);
		Users deluser = null ;
		entityTransaction.begin();
		for (Users user : netflix.getUsers()) {
			if (user.getId() == uid)
			deluser = deluser ;
		}
		netflix.getUsers().remove(deluser) ;
		entityManager.remove(deluser);
		entityManager.merge(netflix) ;
		entityTransaction.commit();
	}
}
