package edu.jsp.foodapp.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.jsp.foodapp.bean.Product;

public class ProductController {
	static Connection connnection = null ;
	static {
		
		try {
			Class.forName("org.postgresql.Driver") ;
			
		    connnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FoodApp_jdbc?user=postgres&password=root") ;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void saveProduct(Product product) {
		
		try {
			PreparedStatement statement = connnection.prepareStatement("insert into product values (?,?,?,?,?)") ;
			
			statement.setInt(1, product.getProductId());
			statement.setString(2, product.getProductName());
			statement.setString(3, product.getDiscription());
			statement.setDouble(4, product.getPrice());
			statement.setInt(5, product.getOrderId());
			
			statement.executeUpdate() ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Product fetchProductById(int id ) {
		
		Product product = new Product() ;
		
		try {
			CallableStatement statement = connnection.prepareCall("select * from product where order_id=?") ;
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery() ;
			
			while (result.next()) {
				
				product.setOrderId(result.getInt(1));
				product.setProductName(result.getString(2));
				product.setDiscription(result.getString(3));
				product.setPrice(result.getDouble(4));
				product.setOrderId(result.getInt(5));
				
			}
			return product ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	public String updateProductById(int id, double price) {
		
		Product product = fetchProductById(id) ;
		
		try {
			if (product != null) {
				CallableStatement statement = connnection.prepareCall("update product set product_price = ? where product_id = ?") ;
				statement.setInt(1, id);
				statement.setDouble(2, price);
				statement.executeUpdate() ;
				return "Updated Successfully" ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Failed to update";
	}
	
	public String deleteProductById(int id) {
		
		try {
			CallableStatement statement = connnection.prepareCall("delete from product where product_id = ?") ;
			Product product = fetchProductById(id) ;
			if (product != null) {
				statement.setInt(1, id);
				statement.executeUpdate() ;
				return "Product Deleted Successfully " ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return "Failed to Delete Check The ID" ;
	}
}
