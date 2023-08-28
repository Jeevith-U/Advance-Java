package edu.svit.customeranditem.controller;

import java.util.List;

import edu.svit.customeranditem.model.Customer;
import edu.svit.customeranditem.model.Item;

public class Controller {
	
	Customer customer = new Customer() ;
	
	public void addCustomer(Customer cus) {
		
		customer = cus ;
		
	}
	
	public Item findItemByName(String name) {
		
		List<Item> list = customer.getListofItems() ;
		
		for (Item item : list) {
			
			if (item.getItemName().equalsIgnoreCase(name)) {
				return item ;
			}
		}
		return null;
	}
	
	public void UpdateItem(String name, int quantity) {
		
		Item items = findItemByName(name) ;
		
		if (items != null) {
			items.setQuantity(quantity);
		}
	}
	
	public void deleteItem(String name) {
		
		Item delItems = findItemByName(name) ;
		if (delItems != null) {
			
			customer.getListofItems().remove(delItems) ;
		}
	}
	
	public List<Item> displayAll() {
		
	List<Item> items = customer.getListofItems() ;
	
	return items ;
	}
}
