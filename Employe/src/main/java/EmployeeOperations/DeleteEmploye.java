package EmployeeOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEmploye {
	
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/employee" ;
		String user = "postgres" ;
		String pass = "root" ;
		
		try {
			Class.forName("org.postgresql.Driver") ;
			
			Connection con = DriverManager.getConnection(url, user, pass) ;
			
			Statement stmt = con.createStatement() ;
			
			String query = "delete from employe where emp_id = 203 " ;
			
			stmt.execute(query) ;
			
			con.close();
			
			System.out.println("Data deleted !");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
