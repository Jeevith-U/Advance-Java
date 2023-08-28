package TeacherOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetriveTeachers {
	
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/employee" ;
		String user = "postgres" ;
		String pass = "root" ;
		
		try {
			Class.forName("org.postgresql.Driver") ;
			
			Connection con = DriverManager.getConnection(url, user, pass) ;
			
			Statement stm = con.createStatement() ;
			
			String query = "select * from teacher" ;
			
			ResultSet rs = stm.executeQuery(query) ;
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getLong(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getLong(6));
				System.out.println(rs.getString(7));
				System.out.println(rs.getString(8));
				System.out.println("\n");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
