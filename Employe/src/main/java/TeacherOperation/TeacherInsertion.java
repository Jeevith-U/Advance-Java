package TeacherOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherInsertion {
	
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/employee" ;
		String user = "postgres" ;
		String pass = "root" ;
		
		try {
			Class.forName("org.postgresql.Driver") ;
			
			Connection con = DriverManager.getConnection(url, user, pass) ;
			
			Statement stmt = con.createStatement() ;
			
			String query = "insert into teacher values(1, 'RangaSwami', 'rangaswami@gmail.com', 9986965967,'Biology', 35000, 'Princeple', 'govt high school')" ;
			
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
