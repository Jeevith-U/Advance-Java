package edu.jsp.encryptionanddecryption.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.jsp.encryptionanddecryption.bean.User;
import edu.jsp.encryptionanddecryption.exception.PasswordMissMatchExecption;
import edu.jsp.encryptionanddecryption.utill.AESImpleExample;

public class UserController {
	
	static Connection connection = null ;
	
	static {
		
		try {
			Class.forName("org.postgresql.Driver") ;
			
			connection =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/Encryption?user=postgres&password=root") ;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String saveUser(User user) {
		
		try {
			 PreparedStatement statement = connection.prepareStatement("insert into encryption values (?,?,?,?)") ;
			
			 String encryptedpassword = AESImpleExample.encrypt(user.getPassword()) ;
			 
			statement.setInt(1, user.getId());
			statement.setString(2, user.getName());
			statement.setString(3, user.getEmail());
			statement.setString(4, encryptedpassword);
			
			statement.execute() ;
			return "User Saved Successfylly" ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null ;
	}
	
	public User findUserById(int id, String password ) {
		
		User user = new User() ; 
		
		try {
			PreparedStatement statement = connection.prepareStatement("select * from encryption where id = ?") ;
			
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery() ;
			
			while (result.next()) {
				
				user.setId(result.getInt(1));
				user.setName(result.getString(2));
				user.setEmail(result.getString(3));
				String decryptedPasswords = AESImpleExample.decrypt(result.getString(4));
				user.setPassword(decryptedPasswords) ;
				if (password.equals(decryptedPasswords)) {
					return user ;
				}
				else {
					throw new PasswordMissMatchExecption("Password Is not Matching") ;
				}
				
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
		return null ;
	}
}
