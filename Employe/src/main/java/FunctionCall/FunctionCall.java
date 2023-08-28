package FunctionCall;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class FunctionCall {
	
	public static void main(String[] args) {
		
		try {
			
            Class.forName("org.postgresql.Driver") ;
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee?user=postgres&password=root") ;
			
			CallableStatement cst = con.prepareCall("select call_by_id (?)") ;
			
			cst.setString(1, "female") ;
			
			ResultSet rs = cst.executeQuery() ;
			
			rs.next() ;
			
			int result = rs.getInt(1) ;
			
			System.out.println("the result is "+result);
			con.close() ;
		} catch (Exception e) {
			
			e.printStackTrace() ;
		}
	}
}
