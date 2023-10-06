package ModelMap;

import java.util.Map;

public class Shop {
	
	
	private String name ;
	private Map<String, Double> items ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Double> getItems() {
		return items;
	}
	public void setItems(Map<String, Double> items) {
		this.items = items;
	}
	
	
}
