package test;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class Test {
	
	public static void main(String[] args) {

		try {
			
			Class.forName("org.postgresql.Driver") ;
			
			System.out.println("Driver Registerd..");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
