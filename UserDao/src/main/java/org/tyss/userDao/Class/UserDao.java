package org.tyss.userDao.Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.tyss.exception.InvalidPassword;

public class UserDao {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in ) ;
		
		System.out.println("Select the operation you want to perform\n1.Insert User\n2.Find User\n3.Update User\n4.Delete User");
		
		 UserDao u = new UserDao();
		int num = sc.nextInt() ;
		switch (num) {
		case 1:boolean flag = true ;
			   while(flag) {
			  System.out.println("Enter the id");
			  int id = sc.nextInt() ;
			  System.out.println("Enter the name");
			  String str = sc.next() ;
			  System.out.println("Enter the email id");
			  String em = sc.next() ;
			  System.out.println("Enter the phone number");
			  long ph = sc.nextLong() ;
			  System.out.println("Enter the password");
			  String pas = sc.next() ;
			 
			  u.saveUser(id, str, em, ph, pas);
			  System.out.println("Do you want instert another one \n1.yes\n2.no");
			  int res = sc.nextInt() ;
			  if (res != 1) {
				flag = false ;
			}
			   }
			break;
			
		case 2 :
			System.out.println("Enter the id you wanna fetch");
			int id = sc.nextInt() ;
			u.fetchById(id, sc) ;
			break;
			
		case 3 :
			System.out.println("Enter the id you want to update");
			int up = sc.nextInt() ;
			u.updateUser(up,sc) ;
			break;
		case 4:
			System.out.println("Enter the id you wanna delete");
			int del = sc.nextInt() ;
			u.deleteUser(del,sc) ;
			break;
		default:
			System.out.println("select anyone from above");
			break;
		}
	}
	
	public void updateUser(int up, Scanner sc ) {
		
		try {
			Class.forName("org.postgresql.Driver") ;
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop?user=postgres&password=root") ;
			System.out.println("Updating entity \n1.name \n2.email\n3.phno\n4.password");
			int update = sc.nextInt() ;
			switch (update) {
			case 1:
				PreparedStatement st = con.prepareStatement("update newuser set name =? where name = ?") ;
				System.out.println("Enter old name");
				String on = sc.next() ;
				System.out.println("Enter the new name");
				String nn = sc.next() ;
				st.setString(1, nn) ;
				st.setString(2, on) ;
				st.execute() ;
				System.out.println("Updated successfully ");
				/*con.close() ;*/
				break;
				
			case 2:
				PreparedStatement pst = con.prepareStatement("update newuser set email =? where email =?") ;
				System.out.println("Enter old email");
				String oe = sc.next() ;
				System.out.println("Enter the new email");
				String ne = sc.next() ;
				pst.setString(1, ne) ;
				pst.setString(2, oe) ;
				pst.execute() ;
				System.out.println("Updated successfully ");
				/*con.close() ;*/
				break ;
				
			case 3 :
				PreparedStatement phst = con.prepareStatement("update newuser set phno =? where phno =?") ;
				System.out.println("Enter old phno");
				String oph = sc.next() ;
				System.out.println("Enter the new phno");
				String nph = sc.next() ;
				phst.setString(1, nph) ;
				phst.setString(2, oph) ;
				phst.execute() ;
				System.out.println("Updated successfully ");
				/*con.close() ;*/
				break ;
			default:
				break;
			}
			PreparedStatement st = con.prepareStatement("update newuser set(?,?,?,?,?)");
			
			System.out.println("User updated !");
			con.close() ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int id, Scanner sc) {
		try {
			Class.forName("org.postgresql.Driver") ;
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop?user=postgres&password=root") ;
			PreparedStatement st = con.prepareStatement("delete from newuser where id=?") ;
			if ( fetchById(id, sc) == 1) {
				st.setInt(1, id) ;
				st.execute() ;
				System.out.println("User with id "+id+" deleted");
			}else
			System.out.println("Id is not present");
			con.close() ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int fetchById(int id, Scanner sc)   {
		
		try {
			Class.forName("org.postgresql.Driver") ;
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop?user=postgres&password=root") ;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from newuser where id ="+id+"") ;
				try{
					
						while (rs.next()) {
							System.out.println("id :"+rs.getInt(1));
							System.out.println("name :"+rs.getString(2));
							System.out.println("email :"+rs.getString(3));
							System.out.println("phno :"+ rs.getLong(4));
							System.out.println("Enter the password to verify you are valid user");
							String s =sc.next() ;
					
						if (s.equals(rs.getString(5))) {
							System.out.println("Passwoerd : "+rs.getString(5));
						}else { 
							throw new InvalidPassword("Password is not matching") ;
				        }
						
						if (id == rs.getInt(1)) {
							return 1 ;
						}
						
				}
				}
					
				catch(Exception e) {
					e.printStackTrace() ;
				}
			con.close() ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	public void saveUser(int id, String str, String em, long ph, String pas) {
		
		try {
			Class.forName("org.postgresql.Driver") ;
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop?user=postgres&password=root") ;
			PreparedStatement st = con.prepareStatement("Insert into newuser values(?,?,?,?,?)");
			st.setInt(1, id) ;
			st.setString(2, str) ;
			st.setString(3, em) ;
			st.setLong(4, ph) ;
			st.setString(5, pas) ;
			st.execute() ;
			System.out.println("User Inserted !");
			con.close() ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
   }
}
