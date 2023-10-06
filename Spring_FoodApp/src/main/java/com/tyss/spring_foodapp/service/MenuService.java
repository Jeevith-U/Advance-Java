package com.tyss.spring_foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tyss.spring_foodapp.dao.MenuDao;
import com.tyss.spring_foodapp.dto.Menu;

@Component
@Scope(value = "prototype")
public class MenuService {
	
	@Autowired
	private MenuDao dao ;
	
	public Menu saveMenu (Menu menu) {
		Menu menuu = dao.saveMenu(menu) ;
		return menuu ;
	}
	
	public Menu findMenu(int id ) {
		return dao.findMenu(id) ;
	}
	
	public Menu updateMenu(Menu menu) {
		return dao.updateMenu(menu) ;
	}
	
	public boolean deleteMenu(int id) {
		return dao.delete(id) ;
	}
}
