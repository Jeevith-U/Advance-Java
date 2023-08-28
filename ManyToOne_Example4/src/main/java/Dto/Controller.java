package Dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import Model.Vehicle;
public class Controller {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	public void save(Vehicle vehicle) {

		entityTransaction.begin();
		entityManager.persist(vehicle);
		entityManager.persist(vehicle.getPerson());
		entityTransaction.commit();
	}

	public void findVehicle(int id) {

		Vehicle vehicle = entityManager.find(Vehicle.class, id);

		System.out.println("Vehicle Id : " + vehicle.getId());
		System.out.println("Vehicle name : " + vehicle.getVehicle());
		System.out.println("Vehicle price : " + vehicle.getPrice());

		System.out.println();
		System.out.println("Person Details ");
		System.out.println("Person Id : " + vehicle.getPerson().getId());
		System.out.println("Person Name : " + vehicle.getPerson().getName());
	}

	public void updateName(int id, String name) {
		entityTransaction.begin();
		Vehicle add = entityManager.find(Vehicle.class, id);
		add.setVehicle(name);
		entityManager.merge(add);
		entityTransaction.commit();
	}

	public void deleteVehicle(int id) {

		Vehicle add = entityManager.find(Vehicle.class, id);

		entityTransaction.begin();
		entityManager.remove(add);
		entityTransaction.commit();
	}

}
