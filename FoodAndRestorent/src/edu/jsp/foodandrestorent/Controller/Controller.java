package edu.jsp.foodandrestorent.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.jsp.foodandrestorent.model.Customer;
import edu.jsp.foodandrestorent.model.Items;

public class Controller {
	
	Customer customer  ;
	
	
	public double save(Customer cus) {
		customer = cus ;
		double total = showTotalBill(cus) ;
		return total ;
	}

	private double showTotalBill(Customer cus) {
		
		List<Items> list = cus.getItemsList() ;
		
		double total = 0.0 ;
		for (Items items : list) {
			
			total += items.getPrice() ;
		}
		return total  ;
	}
	
	public Items findItem(String itemName) {
		List<Items> item = customer.getItemsList() ;
		for (Items items2 : item) {
			
			if (items2.getItemName().equalsIgnoreCase(itemName)) {
				return items2 ;
			}
		}
		return null;
		
	}
	
	public void updateItemByName(String Name, int quantity ) {
		Items updateItem = findItem(Name) ;
		if (updateItem != null ) {
			updateItem.setQuantity(quantity);
		}
	}
	
	public void deleteItem(String name) {
		 Items delitem = findItem(name) ;
		if (delitem != null) {
			customer.getItemsList().remove(delitem) ;
		}
	}
	
	public List<Items> findAllItems(){
		
		return customer.getItemsList() ;
	}
	
}
