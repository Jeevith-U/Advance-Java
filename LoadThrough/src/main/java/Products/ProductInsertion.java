package Products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProductInsertion {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		try {
			Class.forName("org.postgresql.Driver") ;
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop?user=postgres&password=root") ;
			
		    Statement st = con.createStatement() ;
		    
		    System.out.println("Enter the number of users ");
		    
		    int users = sc.nextInt() ;
		    
		    
		    for (int i = 0; i < users ; i++) {
		    	
		    	System.out.println("Enter the name of item");
		    	String name = sc.next() ;
		    	
		    	System.out.println("Enter the id of item");
		    	int id = sc.nextInt() ;
		    	
		    	System.out.println("Enter the name of item");
		    	String iname = sc.next() ;
		    	
		    	System.out.println("Enter the Quantity of item needed");
		    	int quan = sc.nextInt() ;
		    	
		    	System.out.println("Enter the price item");
		    	long price = sc.nextLong() ;
		    	
		    	System.out.println("Enter the item Manufracture name");
		    	String mname = sc.next() ;
		    	
		    	 int returnType = st.executeUpdate("insert into products values('"+name+"',"+id+",'"+iname+"',"+quan+","+price+" ,'"+mname+"')") ;
		    	System.out.println(returnType);
		    	System.out.println("Data inserted !");
		    	
			}
		    
		    con.close() ;
	    	System.out.println("All data inserted ");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
