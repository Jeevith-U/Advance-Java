package EmployeeOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmploye {
	
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/employee" ;
		String user = "postgres" ;
		String pass = "root" ;
		
		try {
			Class.forName("org.postgresql.Driver") ;
			
			Connection con = DriverManager.getConnection(url, user, pass) ;
			
			Statement stmt = con.createStatement() ;
			
			String query = "insert into employe values(204, 'johnwick', 'hardware developer', 9986965967,'hardware', 35000, 'john@22$')" ;
			
			stmt.execute(query) ;
			
			con.close();
			
			System.out.println("Data inserted !");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
