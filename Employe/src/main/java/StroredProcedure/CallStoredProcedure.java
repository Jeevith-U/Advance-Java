package StroredProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallStoredProcedure {
	
	public static void main(String[] args) {
		 
		try {
			Class.forName("org.postgresql.Driver") ;
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee?user=postgres&password=root") ;
			
			CallableStatement cst = con.prepareCall("call emp_stored_procedure (?,?,?,?,?,?,?)") ;
			
			cst.setInt(1, 21 ) ;
			cst.setString(2, "nish") ;
			cst.setString(3, "female") ;
			cst.setInt(4, 21) ;
			cst.setString(5, "nish@gmail.com") ;
			cst.setLong(6, 87655688) ;
			cst.setString(7, "O+ve") ;
			
			cst.execute() ;
			System.out.println("updated");
			con.close() ;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
