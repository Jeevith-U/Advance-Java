package com.tyss.food_app.userDao;

import com.tyss.food_app.entity.Menu;

public interface MenuDao {
	
	public Menu saveMenu(Menu menu) ;
	
	public Menu findMenu(int id) ;
	
	public Menu updateMenu(Menu menu) ;
	
	public boolean delete(int id) ;
	
	public String rating(String starts) ;

}
