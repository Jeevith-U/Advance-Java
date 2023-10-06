package DIMapUsingConstructor;

import java.util.Iterator;
import java.util.Map;import java.util.Map.Entry;

public class Shop {
	
	private String name ; 
	private Map<String, Double> items ;
	public Shop(String name, Map<String, Double> items) {
		super();
		this.name = name;
		this.items = items;
	}
	
	public void diplay() {
		
		System.out.println(name);
		System.out.println("--------items---------");
		for( Map.Entry<String, Double> entry : items.entrySet()) {
		
		System.out.println(entry.getKey()+"---->"+entry.getValue());
		}
	}
}
