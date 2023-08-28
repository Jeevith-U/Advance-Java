package edu.tyss.Practice_OneToOne_Bidirection.Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.Practice_OneToOne_Bidirection.model.Key;
import edu.tyss.Practice_OneToOne_Bidirection.model.Lock;

public class Controller {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	static EntityManager entityManager2 = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction2 = entityManager2.getTransaction();

	public static void main(String[] args) {

//		save() ;

		find();

		anotherFind();

//		keyToLockUpdate() ;
	}

	private static void anotherFind() {

		Lock lock = entityManager2.find(Lock.class, 101);

		System.out.println(lock.getLock_Id());
		System.out.println(lock.getName());
		System.out.println();
		Key key = entityManager2.find(Key.class, 2323);
		System.out.println(key.getKey_Id());
		System.out.println(key.getKey_num());
		System.out.println(key.getName());

	}

	public static void save() {

		Lock lock = new Lock();

		lock.setLock_Id(101);
		lock.setName("Helma");

		Key key = new Key();
		key.setKey_Id(2323);
		key.setName("Helma_key");
		key.setKey_num(1012323);
		key.setLock(lock);

		lock.setKey(key);

		entityTransaction.begin();
		entityManager.persist(lock);
		entityManager.persist(key);
		entityTransaction.commit();
	}

	public static void find() {

		Lock lock = entityManager.find(Lock.class, 101);

		System.out.println(lock.getLock_Id());
		System.out.println(lock.getName());
		System.out.println();
		Key key = entityManager.find(Key.class, 2323);
		System.out.println(key.getKey_Id());
		System.out.println(key.getKey_num());
		System.out.println(key.getName());

	}

	public static void keyToLockUpdate() {

		entityTransaction.begin();

		Key key = entityManager.find(Key.class, 2323);

		key.getLock().setName("Meera");

		entityManager.merge(key);

		entityTransaction.commit();
	}
}
