package edu.hibernate_assignment.Dao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import edu.hibernate_assignment.dto.Branch;
import edu.hibernate_assignment.dto.FoodOrder;
import edu.hibernate_assignment.dto.Food_Product;
import edu.hibernate_assignment.dto.Items;
import edu.hibernate_assignment.dto.Menu;
import edu.hibernate_assignment.dto.Role;
import edu.hibernate_assignment.dto.Type;
import edu.hibernate_assignment.dto.Users;

public class UserDao {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public static void main(String[] args) {
		
		UserDao dao = new UserDao() ;
		
//		dao.saveUser();
		
//		dao.findUser() ;
		
//		dao.updateBranchName() ;
		
//		dao.updateFoodProduct() ;
		
		dao.deleteUser() ;
		
	}
	
	private void deleteUser() {
		
		Users user = entityManager.find(Users.class, 21) ;
		
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit(); 
	}

	private void updateFoodProduct() {
		
		entityTransaction.begin();
		
		Users user = entityManager.find(Users.class, 21) ;
		
		Menu menu = user.getMenu() ;
		
		List<Food_Product> list = menu.getFoodProductList() ;
		
		for (Food_Product food : list) {
			
			if (food.getId() == 3) {
				food.setAvailability(true);
			}
			entityManager.merge(food) ;
			break ;
		}
		
		entityManager.merge(menu) ;
		entityManager.merge(user) ;
		entityTransaction.commit();
	}

	private void updateBranchName() {
		
		entityTransaction.begin();
		Users user1 = entityManager.find(Users.class, 22) ;
		
		List<Branch> branchs = user1.getBranchList() ;
		
		for (Branch branch : branchs) {
			if (branch.getId() ==  202) {
				
				branch.setName("Old Mysore");
			}
			
			entityManager.merge(branch) ;
		}
		entityManager.merge(user1) ;
		entityTransaction.commit();
		
	}

	private void findUser() {
		
		Users user1 = entityManager.find(Users.class, 22) ;
		
		System.out.println("User Id : "+user1.getId());
		System.out.println("User Name : "+user1.getName());
		System.out.println("User Email : "+user1.getEmail());
		System.out.println("User Role : "+user1.getRole());
		System.out.println();
		
		System.out.println();
		System.out.println("-------------BRANCH INFO-----------------");
		List<Branch> branchs = user1.getBranchList() ;
		for (Branch branch : branchs) {
			System.out.println("Branch ID : "+branch.getId());
			System.out.println("Branch ID : "+branch.getName());
			System.out.println("Branch ID : "+branch.getAddress());
			System.out.println("Branch ID : "+branch.getPhno());
			System.out.println("Branch ID : "+branch.getEmail());
			System.out.println();
			
		}
		
		System.out.println("-------------MENU INFO-----------------");
		System.out.println("Users Menu contains following food : ");
		List<Food_Product> menu = user1.getMenu().getFoodProductList() ;
		for (Food_Product  food: menu) {
			System.out.println("Food Name : "+food.getName());
			System.out.println("Food Type : "+food.getType());
			System.out.println("Food Discription : "+food.getAbout());
			System.out.println("Food Price : "+food.getPrice());
			System.out.println();
			
			System.out.println("-------------FOOD PRODUCT INFO-----------------");
			
		}
		
		System.out.println("-------------FOOD ORDER INFO-----------------");
		List<FoodOrder> orders = user1.getListOfOrder() ;
		for (FoodOrder order : orders) {
			System.out.println("Oder Id : "+order.getId());
			System.out.println("Oder Customer Name : "+order.getCustomerName());
			System.out.println("Oder Contact Number : "+order.getContactNumber());
			System.out.println("Oder Ordered Time : "+order.getOrderCreatedTime());
			System.out.println("Oder Deliverd Time : "+order.getOrderDeliveryTime());
			System.out.println("Oder Status : "+order.isStatus());
			System.out.println("Oder Price : "+order.getPrice());
			System.out.println();
			
			System.out.println("-------------ITEM INFO-----------------");
			List<Items> items = order.getItemList() ;
			
			for ( Items item  : items) {
				System.out.println("Item Id : "+item.getId());
				System.out.println("Item Id : "+item.getProductId());
				System.out.println("Item Id : "+item.getName());
				System.out.println("Item Id : "+item.getType());
				System.out.println("Item Id : "+item.getQuantity());
				System.out.println("Item Id : "+item.getPrice());
				System.out.println();
			}
		}
	}

	public void saveUser() {
		
		Users user = new Users() ;
		user.setName("Tony");
		user.setEmail("tony@gmail.com");
		user.setPassword("tony@manager22");
		user.setRole(String.valueOf(Role.MANAGER ));
		
		Menu menu = new Menu() ;
		
		Food_Product product = new Food_Product();
		product.setName("Dosa");
		product.setType(String.valueOf(Type.VEGAN));
		product.setAbout("Made of rice batter and added with coconut oil heated in low flam for 30 min");
		product.setAvailability(true);
		product.setPrice(60);
		
		Food_Product product1 = new Food_Product() ;
		product1.setName("CurryDosa");
		product1.setType(String.valueOf(Type.NONVEG));
		product1.setAbout("Dosa with fresh chicken curry ");
		product1.setAvailability(true);
		product1.setPrice(99);
		
		Food_Product product2 = new Food_Product() ;
		
		product2.setName("Tea");
		product2.setType(String.valueOf(Type.VEG));
		product2.setAbout("Made with milk and imported tea powder from kerala mixed with mandya sugar");
		product2.setAvailability(false);
		product2.setPrice(12);
		
		List<Food_Product> productList = Arrays.asList(product, product1, product2) ;
		menu.setFoodProductList(productList);
		menu.setUsers(user);
		user.setMenu(menu);
		
		Users user2 = new Users() ;
		user2.setName("sanji");
		user2.setEmail("sanji@admin");
		user2.setPassword("sanji@admin22");
		user2.setRole(String.valueOf(Role.ADMIN));
		
		Menu menu2 = new Menu() ;
		
		Food_Product product3 = new Food_Product() ;
		product3.setName("Idli");
		product3.setType(String.valueOf(Type.VEGAN));
		product3.setAbout("Made with rice batter and cooked in steam for 30 min");
		product3.setAvailability(true);
		product3.setPrice(45);
		
		Food_Product product4 = new Food_Product() ;
		product4.setName("Vada");
		product4.setType(String.valueOf(Type.VEG));
		product4.setAbout("made with udinbele and deep fried in oil for 10 min");
		product4.setAvailability(true);
		product4.setPrice(20);
		
		List<Food_Product> productList2 = Arrays.asList(product3, product4) ;
		menu2.setFoodProductList(productList2);
		menu2.setUsers(user2);
		
		user2.setMenu(menu2);
		
		Branch branch = new Branch() ;
		
		branch.setName("Mysore");
		branch.setAddress("Kuvemou nagar");
		branch.setPhno(98765432);
		branch.setEmail("mysoreBranch@gmail.com");
		branch.setUsers(user2);
		
		Branch branch2 = new Branch() ;
		branch2.setName("Banglore");
		branch2.setAddress("JayNagar");
		branch2.setPhno(98765445);
		branch2.setEmail("bangloreBranch@gmail.com");
		branch2.setUsers(user2);
		
		List<Branch> branchList = Arrays.asList(branch, branch2) ;
		
		user.setBranchList(branchList);
		user2.setBranchList(branchList);
		
		FoodOrder order1 = new FoodOrder() ;
		order1.setCustomerName("Jeevith");
		order1.setContactNumber(98765324);
		order1.setStatus(true);
		order1.setUsers(user);
		
		FoodOrder order2 = new FoodOrder() ;
		order2.setCustomerName("Luffy");
		order2.setContactNumber(98765432);
		order2.setStatus(true);
		order2.setPrice(4999);
		
		Items item1 = new Items() ;
		item1.setProductId(42352);
		item1.setName("dosa");
		item1.setType(String.valueOf(Type.VEGAN));
		item1.setQuantity(4);
		item1.setPrice(120);
		
		Items items2 = new Items() ;
		
		items2.setProductId(54512);
		items2.setName("CurryDosa");
		items2.setType(String.valueOf(Type.NONVEG));
		items2.setQuantity(2);
		items2.setPrice(120);
		
		List<Items> itemsList = Arrays.asList(item1, items2) ;
		
		order1.setItemList(itemsList);
		order2.setItemList(itemsList);
		
		List<FoodOrder> foodOrderList = Arrays.asList(order1, order2) ;
		
		user.setListOfOrder(foodOrderList);
		user2.setListOfOrder(foodOrderList);
		
		entityTransaction.begin();
		entityManager.persist(user);
		entityManager.persist(user2);
		entityManager.persist(menu);
		entityManager.persist(menu2);
		entityManager.persist(order1);
		entityManager.persist(order2);
		entityManager.persist(branch);
		entityManager.persist(branch2);
		entityManager.persist(product);
		entityManager.persist(product1);
		entityManager.persist(product2);
		entityManager.persist(product3);
		entityManager.persist(product4);
		entityManager.persist(item1);
		entityManager.persist(items2);
		entityTransaction.commit();

		
	}
}
