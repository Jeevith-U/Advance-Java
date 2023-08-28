package edu.hibernate_assignment._dynamic.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.hibernate_assignment_dynamic.dto.Branch;
import edu.hibernate_assignment_dynamic.dto.FoodOrder;
import edu.hibernate_assignment_dynamic.dto.Food_Product;
import edu.hibernate_assignment_dynamic.dto.Items;
import edu.hibernate_assignment_dynamic.dto.Menu;
import edu.hibernate_assignment_dynamic.dto.Users;

public class UserDao {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveUserStaff(Users user) {

		List<FoodOrder> list = user.getListOfOrder();

		entityTransaction.begin();
		entityManager.persist(user);
		for (FoodOrder foodOrder : list) {
			entityManager.persist(foodOrder);
			List<Items> items = foodOrder.getItemList();
			for (Items item : items) {
				entityManager.persist(item);
			}
		}
		entityTransaction.commit();
	}

	public void saveUserBranchManager(Users user) {

		List<Branch> list = user.getBranchList();

		entityTransaction.begin();
		entityManager.persist(user);
		for (Branch branch : list) {
			entityManager.persist(branch);
		}
		entityTransaction.commit();
	}

	public void saveAdmin(Users users) {

		Menu menu = users.getMenu();

		List<Food_Product> list = menu.getFoodProductList();

		entityTransaction.begin();
		entityManager.persist(users);
		entityManager.persist(menu);
		for (Food_Product Product : list) {
			entityManager.persist(Product);
		}
		entityTransaction.commit();
	}

	public Users findStaff(int id) {

		Users user = entityManager.find(Users.class, id);

		return user;

	}

	public Users findAdmin(int id) {

		Users user = entityManager.find(Users.class, id);

		return user;
	}

	public Users findManager(int id) {

		Users user = entityManager.find(Users.class, id);

		return user;

	}
	
	public void updateBranch(int id, String newAddress) {
		entityTransaction.begin();
		Branch branch = entityManager.find(Branch.class, id) ;
		branch.setAddress(newAddress);
		entityManager.merge(branch) ;
		entityManager.merge(branch.getUsers()) ;
		entityTransaction.commit();
	}
	
	public void updateItem(int id , int newQuantity) {
		
		entityTransaction.begin();
		Items item = entityManager.find(Items.class, id) ;
		System.out.println(item);
		item.setQuantity(newQuantity);
		entityManager.merge(item) ;
		System.out.println("Merged-1");
		entityManager.merge(item.getFoodOrder()) ;
		System.out.println("Merged-2");
//		Users user = item.getFoodOrder().getUsers() ;
//		entityManager.merge(user) ;
//		System.out.println("Merged-3");
		entityTransaction.commit();
	}
	
	public void deleteFoodProduct(int id) {
		entityTransaction.begin();
		Food_Product product = entityManager.find(Food_Product.class, id) ;
		System.out.println(product);
		entityManager.remove(product);
		entityTransaction.commit();
	}
}
