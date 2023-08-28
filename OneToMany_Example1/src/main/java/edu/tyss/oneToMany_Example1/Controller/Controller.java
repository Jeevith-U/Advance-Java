package edu.tyss.oneToMany_Example1.Controller;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.oneToMany_Example1.model.Phone;
import edu.tyss.oneToMany_Example1.model.Sim;

public class Controller {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	public void savePhone(Phone phone) {
		List<Sim> list = phone.getSims();

		entityTransaction.begin();
		entityManager.persist(phone);
		for (Sim sim : list) {
			entityManager.persist(sim);
		}
		entityTransaction.commit();
	}

	public void findAllSims(int id) {

		Phone phone = entityManager.find(Phone.class, id);

		for (Sim sim : phone.getSims()) {
			System.out.println("Sim Number : " + sim.getId());
			System.out.println("Sim Number : " + sim.getName());
			System.out.println("Sim Number : " + sim.getNumber());
			System.out.println();
		}
	}

	public void portSim(int id, int sid, String name) {

		Phone phone = entityManager.find(Phone.class, id);
		entityTransaction.begin();
		for (Sim sim : phone.getSims()) {
			if (sim.getId() == sid) {
				sim.setName(name);
				entityManager.merge(sim);
			}
		}

		entityTransaction.commit();
	}

	public void removeSim(int pid, int sid) {

		Phone phone = entityManager.find(Phone.class, pid);
		
		List<Sim> sims = phone.getSims();
		Sim delSim = null;
		for (Sim sim : sims) {
			if (sim.getId() == sid) {
				delSim = sim;
			}
		}
		entityTransaction.begin();
		sims.remove(delSim) ;
		entityManager.remove(delSim);
		entityManager.merge(phone);
		entityTransaction.commit();

	}
}
