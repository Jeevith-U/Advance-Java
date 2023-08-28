package com.jdbc.practice.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveProduct {
	
	public static void main(String[] args) {
		
		try {
			// step - 1 load or register driver
			Class.forName("org.postgresql.Driver") ;
			
			// step 2 get connection 
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop", "postgres", "root") ;
			
			String sql = "insert into product values (104,'Air', 45000, 5)" ;
			
			//step-3 create a statement 
			
			Statement stmt = connection.createStatement() ;
			
			//step - 4 execute the statement
			stmt.execute(sql);
			
			//step - 5 close the connection 
			connection.close();
			System.out.println("Data inserted !");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
