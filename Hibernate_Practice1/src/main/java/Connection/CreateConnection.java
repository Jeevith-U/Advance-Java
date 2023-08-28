package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver") ;
			
			try {
				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee", "postgres", "root") ;
				
				System.out.println("Connection created...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
