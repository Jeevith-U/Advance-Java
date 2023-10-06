package interfaces;

public class Driver {
	
	public static void main(String[] args) {
		
		Animal animal = () -> {
			System.out.println("Animal is Eating Idli sambar");
		} ;
		
		animal.eat();
	}
}
