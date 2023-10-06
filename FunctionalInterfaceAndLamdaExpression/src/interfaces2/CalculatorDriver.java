package interfaces2;

public class CalculatorDriver {
	
	public static void main(String[] args) {
		
		Calculator calculator = (a, b) -> {
			
			System.out.println("The Result is : " +a*b);
		} ;
		
		calculator.multiplication(42, 12);
	}
}
