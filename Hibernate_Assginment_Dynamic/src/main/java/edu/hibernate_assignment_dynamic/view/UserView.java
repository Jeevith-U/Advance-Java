package edu.hibernate_assignment_dynamic.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import edu.hibernate_assignment._dynamic.Dao.UserDao;
import edu.hibernate_assignment_dynamic.dto.Branch;
import edu.hibernate_assignment_dynamic.dto.FoodOrder;
import edu.hibernate_assignment_dynamic.dto.Food_Product;
import edu.hibernate_assignment_dynamic.dto.Items;
import edu.hibernate_assignment_dynamic.dto.Menu;
import edu.hibernate_assignment_dynamic.dto.Role;
import edu.hibernate_assignment_dynamic.dto.Type;
import edu.hibernate_assignment_dynamic.dto.Users;

public class UserView {

	public static void main(String[] args) {

		UserView view = new UserView();

		UserDao dao = new UserDao();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Select The Type Of operation \n1. Add User \n2. Find User \n3. Update \n4. Delete");
		int operation = scanner.nextInt();
		switch (operation) {
		case 1:
			System.out.println("Select The Type Of User \n1. Branch Manager \n2. Admin \n3. staff");
			int n = scanner.nextInt();

			if (n == 1)
				view.createBranchManger(dao, scanner);
			else if (n == 2)
				view.createAdmin(dao, scanner);
			else if (n == 3)
				view.createStaff(dao, scanner);
			else
				System.out.println("Select the valid operation ");
			break;
		case 2:
			
			System.out.println("Whome do you want to find \n1. Manager \n2. Admin \n3. Staff");
			int userselction = scanner.nextInt() ;
			
			if (userselction == 1)
				view.printManagerDetails(dao,scanner) ;
			else if (userselction == 2)
				view.printAdminDetails(dao,scanner) ;
			else if (userselction == 3)
				view.printStaffDetails(dao,scanner) ;
			else
				System.out.println("Select the valid operation ");
			break;
			
		case 3:
			System.out.println("Select what you want To update \n1.Branch Details \n2. Item");
			int updation = scanner.nextInt() ;
			if(updation == 1)
			view.updateBranchDetails(dao,scanner);
			else if (updation == 2)
				view.updateItemsDetails(dao, scanner) ;
			break ;
		case 4:
			view.deletefoodProduct(dao,scanner) ;
			break ;
		default:
			break;
		}

	}

	private void deletefoodProduct(UserDao dao, Scanner scanner) {
		
		System.out.println("Enter the Food Product Id You want to Delete");
		int delId = scanner.nextInt() ;
		dao.deleteFoodProduct(delId);
		System.out.println("deleted...");
	}

	private void updateItemsDetails(UserDao dao, Scanner scanner) {
		
		System.out.println("Enter the Item Id");
		int itemId = scanner.nextInt() ;
		System.out.println("Enter the Quantity");
		int updateName = scanner.nextInt() ;
		dao.updateItem(itemId, updateName);
		System.out.println("Updated...");
		
	}

	public void updateBranchDetails(UserDao dao, Scanner scanner) {
		
		System.out.println("Enter the Branch Id You Wanna Update");
		int updateBranchId = scanner.nextInt() ;
		System.out.println("Enter the New Address");
		scanner.nextLine() ;
		String newAddress = scanner.nextLine() ;
		dao.updateBranch(updateBranchId, newAddress);
		System.out.println("Updated...");
	}

	private void printManagerDetails(UserDao dao, Scanner scanner) {
		
		System.out.println("Enter the Manager ID");
		int managerId = scanner.nextInt() ;
		
		Users user = dao.findManager(managerId) ;
		
		System.out.println("User Id : " + user.getId());
		System.out.println("User Name : " + user.getName());
		System.out.println("User Email : " + user.getEmail());
		System.out.println("User Role : " + user.getRole());
		System.out.println();
		System.out.println("-------------BRANCH INFO-----------------");
		List<Branch> branchs = user.getBranchList() ;
		for (Branch branch : branchs) {
			System.out.println("Branch ID : "+branch.getId());
			System.out.println("Branch ID : "+branch.getName());
			System.out.println("Branch ID : "+branch.getAddress());
			System.out.println("Branch ID : "+branch.getPhno());
			System.out.println("Branch ID : "+branch.getEmail());
			System.out.println();
			
		}
	}

	private void printAdminDetails(UserDao dao, Scanner scanner) {
		
		System.out.println("Enter the Admin ID");
		int adminId = scanner.nextInt() ;
		
		Users user = dao.findAdmin(adminId) ;
		
		System.out.println("User Id : " + user.getId());
		System.out.println("User Name : " + user.getName());
		System.out.println("User Email : " + user.getEmail());
		System.out.println("User Role : " + user.getRole());
		System.out.println();
		
		System.out.println("-------------MENU INFO-----------------");
		System.out.println("Menu ID : "+user.getMenu().getId());
		Menu menu = user.getMenu() ;
		System.out.println("Users Menu contains following Food Products : ");
		System.out.println();
		System.out.println("-------------FOOD PRODUCT INFO-----------------");
		List<Food_Product> productList = menu.getFoodProductList() ;
		System.out.println(productList);
		for (Food_Product  food: productList) {
			System.out.println("Food Name : "+food.getName());
			System.out.println("Food Type : "+food.getType());
			System.out.println("Food Discription : "+food.getAbout());
			System.out.println("Food Price : "+food.getPrice());
			System.out.println();
		}
	}

	private void printStaffDetails(UserDao dao,Scanner scanner) {
		
		System.out.println("Enter the Staff ID");
		int staffId = scanner.nextInt() ;
		Users user = dao.findStaff(staffId) ;
		
		System.out.println("User Id : " + user.getId());
		System.out.println("User Name : " + user.getName());
		System.out.println("User Email : " + user.getEmail());
		System.out.println("User Role : " + user.getRole());
		System.out.println();
		
		System.out.println("-------------FOOD ORDER INFO-----------------");
		List<FoodOrder> orders = user.getListOfOrder() ;
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

	public void createStaff(UserDao dao, Scanner scanner) {

		Users user = new Users();
		System.out.println("Enter the Staff Name");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("Enter the Email");
		String email = scanner.next();
		System.out.println("Enter the password");
		String password = scanner.next();

		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(String.valueOf(Role.STAFF));
		System.out.println("Select The Number Of Orders You Wanna Do");
		int num = scanner.nextInt();

		List<FoodOrder> foodList = new ArrayList<FoodOrder>();
		for (int i = 0; i < num; i++) {

			FoodOrder order1 = new FoodOrder();

			System.out.println("Enter the Customer Name");
			scanner.nextLine();
			String cname = scanner.nextLine();
			System.out.println("Enter the Phone Number");
			Long phno = scanner.nextLong();
			System.out.println("Enter the Total Bill Amount");
			Double price = scanner.nextDouble();

			order1.setCustomerName(cname);
			order1.setContactNumber(phno);
			order1.setPrice(price);
			order1.setStatus(true);
			System.out.println("Enter the Number Of items You Wanna Add to this Order");
			int itemsnum = scanner.nextInt();
			List<Items> itemsList = new ArrayList<Items>();
			for (int j = 0; j < itemsnum; j++) {

				Items item = new Items();
				System.out.println("Enter the Product ID");
				int pid = scanner.nextInt();
				System.out.println("Enter the Product Name");
				scanner.nextLine();
				String pname = scanner.nextLine();
				System.out.println("Enter the Quantity");
				int qua = scanner.nextInt();
				System.out.println("Select the Type Of food \n1. Veg \n2. Vegan \n3. Nonveg");
				int type = scanner.nextInt();
				if (type == 1) {
					item.setType(String.valueOf(Type.VEG));
					item.setPrice(qua * 50);
				} else if (type == 2) {
					item.setType(String.valueOf(Type.VEGAN));
					item.setPrice(qua * 15);
				} else if (type == 3) {
					item.setType(String.valueOf(Type.NONVEG));
				item.setPrice(qua * 90);
				}
				item.setProductId(pid);
				item.setName(pname);
				item.setQuantity(qua);
				item.setFoodOrder(order1);
				itemsList.add(item) ;
			}
			
			foodList.add(order1);
			order1.setItemList(itemsList);
		}
		user.setListOfOrder(foodList);
		dao.saveUserStaff(user);

	}

	public void createAdmin(UserDao dao, Scanner scanner) {

		Users user = new Users();
		System.out.println("Enter the Admin Name");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("Enter the Email");
		String email = scanner.next();
		System.out.println("Enter the password");
		String password = scanner.next();

		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(String.valueOf(Role.ADMIN));

		Menu menu = new Menu();

		System.out.println("Enter the Number of Products");
		int num = scanner.nextInt();

		List<Food_Product> productList = new ArrayList<Food_Product>();

		for (int i = 0; i < num; i++) {

			Food_Product product = new Food_Product();
			System.out.println("Enter the Name");
			scanner.nextLine();
			String aname = scanner.nextLine();
			System.out.println("Enter the Discrption about The Product");
			String about = scanner.nextLine();
			System.out.println("Enter the Price");
			double price = scanner.nextDouble();
			System.out.println("Select the Type Of food \n1. Veg \n2. Vegan \n3. Nonveg");
			int type = scanner.nextInt();

			product.setName(aname);
			product.setAbout(about);
			product.setPrice(price);
			product.setAvailability(true);
			product.setMenu(menu);

			if (type == 1)
				product.setType(String.valueOf(Type.VEG));
			else if (type == 2)
				product.setType(String.valueOf(Type.VEGAN));
			else if (type == 3)
				product.setType(String.valueOf(Type.NONVEG));
			productList.add(product);
		}

		menu.setFoodProductList(productList);
		menu.setUsers(user);
		user.setMenu(menu);

		dao.saveAdmin(user);

	}

	public void createBranchManger(UserDao dao, Scanner scanner) {

		Users user = new Users();

		System.out.println("Enter the BranchManager Name");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("Enter the Email");
		String email = scanner.next();
		System.out.println("Enter the password");
		String password = scanner.next();

		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(String.valueOf(Role.MANAGER));

		System.out.println("How many Branch You want to add User This Manager");
		int num = scanner.nextInt();

		List<Branch> branchlist = new ArrayList<Branch>();
		for (int i = 0; i < num; i++) {
			Branch branch = new Branch();

			System.out.println("Enter the Branch Name");
			String branchName = scanner.next();
			System.out.println("Enter the Address");
			scanner.nextLine();
			String add = scanner.nextLine();
			System.out.println("Enter the Branch Email id");
			String bemail = scanner.next();
			System.out.println("Enter the Branch Phone Number");
			long phno = scanner.nextLong();

			branch.setName(branchName);
			branch.setAddress(add);
			branch.setEmail(bemail);
			branch.setPhno(phno);
			branch.setUsers(user);
			branchlist.add(branch);
		}

		user.setBranchList(branchlist);
		dao.saveUserBranchManager(user);

	}
}
