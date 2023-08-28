package TeacherOperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SingleLineArgument {
	
	public static void main(String[] args) {
		
		try {
			
			FileInputStream input = new FileInputStream("employe.properties") ;
			
			Properties prop = new Properties() ;
			prop.load(input);
			
			String driver = prop.getProperty("driverclass") ;
			Class.forName(driver) ;
			String url = prop.getProperty("url") ;
			Connection con = DriverManager.getConnection(url, prop) ;
			System.out.println(con);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
