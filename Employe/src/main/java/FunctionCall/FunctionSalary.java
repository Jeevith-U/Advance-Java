package FunctionCall;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FunctionSalary {

	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver") ;
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee?user=postgres&password=root") ;
			
			CallableStatement cst = con.prepareCall("select countsal(?)") ;
			cst.setLong(1, 620000) ;
			ResultSet rs = cst.executeQuery() ;
			rs.next() ;
			System.out.println("No ofnsal 620000 is "+rs.getInt(1));
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
