package edu.tyss.onetoone_example1.Dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.onetoone_example1.model.FingerPrint;
import edu.tyss.onetoone_example1.model.Person;

public class Controller {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	public void savePersonAndFingerPrint(Person person) {
		FingerPrint f = person.getFingerPrint() ;
		entityTransaction.begin();
		
		entityManager.persist(person);
		entityManager.persist(f);
		
		entityTransaction.commit();
	}

	public void findFingerPrint(int id) {

		Person fingerPrint = entityManager.find(Person.class, id);

		FingerPrint fingerPrint2 = fingerPrint.getFingerPrint();

		if (fingerPrint.getId() == id || fingerPrint2.getId() == id) {

			System.out.println("Finger ID : " + fingerPrint2.getId());
			System.out.println("Finger ID : " + fingerPrint2.getNumberofPrint());
			System.out.println("Finger ID : " + fingerPrint2.getType());
		}
	}

	public void updateNumberOfPrint(int id, int num) {

		Person fingerPrint = entityManager.find(Person.class, id);

		FingerPrint fingerPrint2 = fingerPrint.getFingerPrint();

		if (fingerPrint.getId() == id || fingerPrint2.getId() == id) {

			entityTransaction.begin();
			fingerPrint2.setNumberofPrint(num);
			entityManager.merge(fingerPrint);
			entityManager.merge(fingerPrint2);
			entityTransaction.commit();
		}
	}

	public void removeFingerPrint(int id) {
		
		FingerPrint fingerPrint = entityManager.find(FingerPrint.class, id) ;
		 
	     entityTransaction.begin();
		 entityManager.remove(fingerPrint);
		 entityTransaction.commit();
	}
}
