package com.tyss.food_app.serviceimplementation;

import java.util.List;

import javax.persistence.Query;

import com.tyss.food_app.entity.Branch;
import com.tyss.food_app.entity.Menu;
import com.tyss.food_app.entity.Users;
import com.tyss.food_app.service.MenuService;
import com.tyss.food_app.userDaoImplementation.MenuDaoImplementation;
import com.tyss.food_app.util.EntityUtil;

public class MenuServiceImplementation implements MenuService{
	
	EntityUtil entityUtil = new EntityUtil() ;
	
	MenuDaoImplementation dao = new MenuDaoImplementation() ;

	
	public Menu saveMenuervice(Menu menu) {
		
		return dao.saveMenu(menu);
	}

	
	public Menu getMenubyIdService(int id) {
		
		return dao.findMenu(id);
	}

	
	public Menu getMenubyBranchIdService(int id) {
		
		Branch branch = entityUtil.manager.find(Branch.class, id) ;
		
		return branch.getUsers().getMenu() ;
		
	}

	
	public Menu getMenuUserIdService(int id) {
		
		Users user = entityUtil.manager.find(Users.class, id) ;
		return user.getMenu();
	}

	
	public Menu updateMenuervice(Menu menu) {
		
		return dao.updateMenu(menu);
	}

	
	public boolean deleteMenuervice(int id) {
		
		return dao.delete(id);
	}

	
	public List<Menu> getAllMenuervice() {
		
		Query query = entityUtil.manager.createQuery("from Menu") ;
		
		return query.getResultList();
	}

}
