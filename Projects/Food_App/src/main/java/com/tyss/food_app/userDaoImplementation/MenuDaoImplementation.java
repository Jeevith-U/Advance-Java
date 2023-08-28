package com.tyss.food_app.userDaoImplementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.food_app.entity.Branch;
import com.tyss.food_app.entity.Menu;
import com.tyss.food_app.userDao.MenuDao;

public class MenuDaoImplementation implements MenuDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Menu saveMenu(Menu menu) {
		
		entityTransaction.begin();
		entityManager.persist(menu);
		entityTransaction.commit();
		
		return menu;
	}

	
	public Menu findMenu(int id) {
		
      Menu menu = entityManager.find(Menu.class, id) ;
		
		if (menu != null) 
			return menu ;
		
		return null;
}

	
	public Menu updateMenu(Menu menu) {
		
        entityTransaction.begin();
		
		Menu updatemenu = findMenu(menu.getId()) ;
		
		if (updatemenu != null) {
			entityManager.merge(updatemenu) ;
			entityTransaction.commit();
			return menu ;
		}
		
		return null;
	}

	
	public boolean delete(int id) {
       entityTransaction.begin();
		
		Menu delmenu = findMenu(id) ;
		
		if (delmenu != null) {
			
			entityManager.remove(delmenu);
			entityTransaction.commit();
			return true ;
		}
		return false;
	}

	
	public String rating(String starts) {
		
		return starts;
	}
	
	

}
