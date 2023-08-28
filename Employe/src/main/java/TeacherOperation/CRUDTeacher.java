package TeacherOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDTeacher {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in) ;
		
		try {
			Class.forName("org.postgresql.Driver") ;
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee", "postgres", "root") ;
			
			Statement st = connection.createStatement(); 
			
			System.out.println("Enter the operation you want to perform \n1. Insert \n2. Update \n3. FetchAll \n4. Delete \n5. Exit");
			
			int operation = scan.nextInt() ;
			
			boolean loop = true ;
			
			while (loop) {
				
				switch (operation) {
				case 1:{
					  System.out.println("Enter the number of Insertion ");
					  int in = scan.nextInt() ;
					  for (int i = 0; i < in; i++) {
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
							
							st.execute("insert into teacher values ("+id+",'"+name+"','"+email+"',"+num+",'"+sub+"',"+sal+",'"+designation+"','"+school+"')") ;
							System.out.println("Data inserted !");
							break ;
					}
					break;
				}
				case 2:{
					
					System.out.println("Enter the id you want update");
					int id = scan.nextInt() ;
					System.out.println("What do u want to update ");
					
					
					st.execute("Update teacher set where id = '+id'");
					break ;
				}
				
				case 3:{
					ResultSet rs = st.executeQuery("select * from teacher") ;
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
					break ;
				}
					
				case 4:
					System.out.println("Enter the Id you want to delete");
					int del = scan.nextInt() ;
					st.execute("delete from teacher where id ="+del+" ") ;
					System.out.println("Teacher with the id "+del+" is deleted ");
					break ;
					
				case 5:
					loop = false ;
				
				}
			}
			
			connection.close() ;
			System.out.println("Bye !");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
