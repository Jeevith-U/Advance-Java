package edu.tyss.oneToMany_Example4.Dto;

import java.util.Arrays;
import java.util.List;

import edu.tyss.oneToMany_Example4.model.Netflix;
import edu.tyss.oneToMany_Example4.model.Users;

public class View {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		View view = new View() ;
		
		view.create(controller) ;
		
//		controller.findAllUser(121);
		
//		controller.updateUser(121, 231, "Telivision");
		
//		controller.updateUser(121, 231, null);
	}

	public void create(Controller controller) {
		
		Netflix netflix = new Netflix() ;
		netflix.setId(121);
		netflix.setName("jee");
		netflix.setPrice(1299);
		
		Users users = new Users() ;
		users.setId(232);
		users.setUserNuber(1);
		users.setUserDevice("Tab");
		
		Users users2 = new Users() ;
		users2.setId(231);
		users2.setUserDevice("Mobile");
		users2.setUserNuber(2);
		
		List<Users>list = Arrays.asList(users, users2) ;
		
		netflix.setUsers(list);
		controller.save(netflix);
		System.out.println("saved...");
		
	}
}
