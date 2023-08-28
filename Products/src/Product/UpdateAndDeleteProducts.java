package Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.postgresql.Driver;

public class UpdateAndDeleteProducts {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		try {
			Driver driver = new Driver() ;
			DriverManager.registerDriver(driver);
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop", "postgres", "root") ;
			
			Statement st = con.createStatement() ;
			System.out.println("1. Update \n2. Delete");
			int input = sc.nextInt() ;
			
			if(input == 1) {
			System.out.println("Enter the attribute number or String that you want to change");
			int num = sc.nextInt() ;
			String str = sc.nextLine() ;
			System.out.println("Enter the id you ");
			int id = sc.nextInt() ;
			st.execute("update products set item_quantity = " +num+" where item_id = "+id+"") ;
			System.out.println("Item updated ");
			}
			
			if(input == 2) {
				System.out.println("Enter the id you want to delete ");
				int id = sc.nextInt() ;
				st.execute("delete from products where item_id = "+id+" ") ;
				System.out.println("item deleted ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
