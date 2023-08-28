package TeacherOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicTeacherInsertion {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in) ;
		
		String url = "jdbc:postgresql://localhost:5432/employee" ;
		String user = "postgres" ;
		String pass = "root" ;
		
		try {
			Class.forName("org.postgresql.Driver") ;
			
			Connection con = DriverManager.getConnection(url, user, pass) ;
			
			System.out.println("Enter the Number of user");
			int users = scan.nextInt() ;
			Statement stmt = con.createStatement() ;
			for (int i = users ; i < 3 ; i++) {
				
				System.out.println("Enter id");
				int id = scan.nextInt() ;
				System.out.println("Enter name");
				String name = scan.next() ;
				System.out.println("Enter email");
				String email = scan.next() ;
				System.out.println("Enter number");
				long num = scan.nextLong() ;
				System.out.println("Enter subject");
				String sub= scan.next() ;
				System.out.println("Enter salary");
				int sal = scan.nextInt() ;
				System.out.println("Enter designation");
				String designation = scan.next() ;
				System.out.println("Enter the school name");
				String school = scan.next() ;
				
				stmt.execute("insert into teacher values("+id+",'"+name+"','"+email+"',"+num+", '"+sub+"',"+sal+",'"+ designation+"','"+school+"')") ;
				System.out.println("data inserted ");	
			}
			
			//stmt.execute("insert into teacher values(3, 'rock', 'rock@gmail.com', 568938366, 'maths', 35000, 'teacher', 'private school')") ;
			
			con.close();
			System.out.println("data inserted ");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
