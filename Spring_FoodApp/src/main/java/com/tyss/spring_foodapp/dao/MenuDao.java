package com.tyss.spring_foodapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tyss.spring_foodapp.dto.Menu;

@Component
@Scope(value = "prototype")
public class MenuDao {

	@Autowired
	private EntityManager entityManager;

	public Menu saveMenu(Menu menu) {

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(menu);
		entityTransaction.commit();

		return menu;
	}

	public Menu findMenu(int id) {

		Menu menu = entityManager.find(Menu.class, id);

		if (menu != null)
			return menu;

		return null;
	}

	public Menu updateMenu(Menu menu) {

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		Menu updatemenu = findMenu(menu.getId());

		if (updatemenu != null) {
			entityManager.merge(updatemenu);
			entityTransaction.commit();
			return menu;
		}

		return null;
	}

	public boolean delete(int id) {

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		Menu delmenu = findMenu(id);

		if (delmenu != null) {

			entityManager.remove(delmenu);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
