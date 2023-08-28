
/*
 * Prepared statement is a child class of statement 
 * prepared statement is an interface and it have its own abstract methods 
 * Using prepared statement we can execute dynamic queries 
 * we can request for the user input at the run time 
 * */

package PreparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatements {
	
	public static void main(String[] args) {
		 
		try {
			
			// step - 1 load and register the driver 
			Class.forName("org.postgresql.Driver") ;
			
			// step - 2 create the connection
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop?user=postgres&password =root") ;
			
			// step - 3 create the Preparedstatement 
			PreparedStatement st = connection.prepareStatement("insert into products values(?,?,?,?,?,?)") ;
		
				st.setString(1, "watch") ;
				st.setInt(2, 22) ;
				st.setString(3, "Rado") ;
				st.setInt(4, 4) ;
				st.setLong(5, 40500) ;
				st.setString(6, "WatchFactory") ;
				
		   // step - 4 execute the statement 	
				st.execute() ;
				System.out.println("Data inserted !");
		   
				
		  // step - 5
			 	connection.close() ;
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
