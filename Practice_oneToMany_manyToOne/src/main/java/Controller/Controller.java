package Controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Model.Hospital;
import Model.Paticent;

public class Controller {
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	static EntityManager entityManager2 = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction2 = entityManager2.getTransaction();

	public static void main(String[] args) {

//		save();

		findHostpitalUsingPatocent();
		System.out.println("---------------------------------------");
		anotherFindHostpitalUsingPatocent();
	}

	private static void anotherFindHostpitalUsingPatocent() {

		Paticent pacient = entityManager2.find(Paticent.class, 2218);

		System.out.println(pacient.getHospital());
	}

	public static void findHostpitalUsingPatocent() {

		Paticent pacient = entityManager.find(Paticent.class, 2218);

		System.out.println(pacient.getHospital());
	}

	public static void save() {

		Hospital hospital = new Hospital();

		hospital.setId(202);
		hospital.setName("JSS");
		hospital.setHospital_Number("Jss202");

		Paticent paticent = new Paticent();

		paticent.setId(4201);
		paticent.setName("LingaRaju");
		paticent.setAmount(90000);
		paticent.setHospital(hospital);

		Paticent paticent2 = new Paticent();

		paticent2.setAmount(34900);
		paticent2.setId(2218);
		paticent2.setName("Susila");
		paticent2.setHospital(hospital);

		List<Paticent> list = Arrays.asList(paticent, paticent2);

		hospital.setListOfPaticents(list);

		entityTransaction.begin();

		entityManager.persist(hospital);

		entityManager.persist(paticent);

		entityManager.persist(paticent2);

		entityTransaction.commit();

	}
}
