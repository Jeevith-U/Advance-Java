package edu.jsp.foodandrestorent.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestModel {
	
	Items items = new Items() ;
	@Test
	void testTestItem() {
		items.setItemId(2264352);
		items.setItemName("Juice");
		items.setQuantity(2);
		items.setPrice(199.90);
	}

}
