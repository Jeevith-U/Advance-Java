package Products;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProductDriver {
	
	public static void main(String[] args) {
		
		List<Product> productList = new ArrayList<Product>() ;
		
		productList.add(new Product(101, "Perfume", "Orien Mall", 1200)) ;
		productList.add(new Product(111, "shoe", "MAntri Square Mall", 1800)) ;
		productList.add(new Product(133, "tie", "sunday Bazra", 80)) ;
		productList.add(new Product(121, "Bag", "lulu Mall", 1990)) ;
		productList.add(new Product(56, "belt", "chikpete", 120)) ;
		
	/*	productList.forEach(j ->{
			
			if (j.getPrice()>1500) {
				System.out.println(j);
			}
		}); */
		
		/*
		 * to find the total cost of all products using stream api
		 */
		
		double totPrice = productList.stream().collect(Collectors.summingDouble(p -> p.getPrice()));
		System.out.println("Total Price : "+totPrice);
		
		/*
		 * to find The Product which is Highest Price 
		 */
		
		Product maxPrice = productList.stream().max((p1, p2) -> (int)p1.getPrice() - (int)p2.getPrice()).get() ;
		System.out.println("Maximum Price : "+maxPrice.getPrice());
		
		Product minPrice = productList.stream().min((p1, p2) -> (int)p1.getPrice() - (int)p2.getPrice()).get() ;
		System.out.println("Minimum Price : "+minPrice.getPrice());
		
		List<Product> list = productList.stream().filter( p -> p.getPrice()>500).map(p -> p).collect(Collectors.toList()) ;
		
		list.forEach(i -> System.out.println(i));
	}
}
