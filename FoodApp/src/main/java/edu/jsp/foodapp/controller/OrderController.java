package edu.jsp.foodapp.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.jsp.foodapp.bean.Order;

public class OrderController {

	static Connection connnection = null;
	static {

		try {
			Class.forName("org.postgresql.Driver");

			connnection = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/FoodApp_jdbc?user=postgres&password=root");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void saveOrder(Order order) {

		try {
			CallableStatement statement = connnection.prepareCall("Insert into orders values (?,?)");

			statement.setInt(1, order.getOrderId());
			statement.setString(2, order.getOrderName());
			statement.executeUpdate() ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Order findOrderByOrderName(String name) {
		Order order = new Order() ;
		try {
			CallableStatement statement = connnection.prepareCall("select * from orders where order_number = ?") ;
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				order.setOrderId(result.getInt(1));
				order.setOrderName(result.getString(2));
			}
			
			return order ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String updateOrderName(String newName, String oldName) {
		
		Order order = findOrderByOrderName(oldName) ;
		
		try {
			CallableStatement statement = connnection.prepareCall("update orders set order_number = ? where order_number = ?") ;
			statement.setString(1, newName);
			statement.setString(2, oldName);
			statement.executeUpdate() ;
			return "Updated successfully" ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Updation failed";
		
	}
	
	public String deleteOrderByName(String name) {
		return name;
		
	}
}
