package DIInjectionUsingPropertiesFile;

public class Mobile {
	
	private int cost ;
	private String name ;
	
	public Mobile(int cost, String name) {
		this.cost = cost;
		this.name = name;
	}

	@Override
	public String toString() {
		return "cost=" + cost + ", name=" + name ;
	}
	
	
	
}
