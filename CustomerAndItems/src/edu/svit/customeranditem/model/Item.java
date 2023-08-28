package edu.svit.customeranditem.model;

public class Item {
	
	private int itemnId ;
	private String itemName;
	private double price ;
	private int quantity ;
	
	
	@Override
	public String toString() {
		return "Item [itemnId=" + itemnId + ", itemName=" + itemName + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
	public int getItemnId() {
		return itemnId;
	}
	public void setItemnId(int itemnId) {
		this.itemnId = itemnId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Item() {
		super();
	}
	
	
}
