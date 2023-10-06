package HighOrderFunction;

public class CalculateDriver {
	
	public static void main(String[] args) {
		
		Printer print = new Printer() ;
		
		print.print((a, b) -> a+b);
	}
	
}
