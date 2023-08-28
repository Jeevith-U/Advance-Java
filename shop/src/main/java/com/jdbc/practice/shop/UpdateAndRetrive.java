package com.jdbc.practice.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateAndRetrive {
	
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/shop" ;
		String user = "postgres" ;
		String pass = "root" ;
		
		try {
			
			// Step - 1
			Class.forName("org.postgresql.Driver") ;
			
			// step - 2 
			
			Connection con = DriverManager.getConnection(url, user, pass) ;
			
			//step - 3 
			
			String query = "select * from product" ;
			
			Statement stmt = con.createStatement() ;
			
			//step - 4 
			//stmt.execute("update product set price = 30000 where id = 101");
			
			ResultSet rs = stmt.executeQuery(query) ;
			
			while (rs.next()) {
				
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getDouble(3));
				System.out.println(rs.getInt(4));
				System.out.println("----------------------------------------------------");
			}
			
			//step - 5
			con.close();
			System.out.println("data updated !");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
