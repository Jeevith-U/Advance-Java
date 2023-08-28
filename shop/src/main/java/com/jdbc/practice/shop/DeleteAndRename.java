package com.jdbc.practice.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteAndRename {
	
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/shop" ;
		String user = "postgres" ;
		String pass = "root" ;
		
		try {
			Class.forName("org.postgresql.Driver") ;
			
			Connection con = DriverManager.getConnection(url, user, pass);
			
			String query = "delete from product where id =103" ;
			
			Statement stmt = con.createStatement() ;
			
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
