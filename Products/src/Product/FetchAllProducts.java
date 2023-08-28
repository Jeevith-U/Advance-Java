package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FetchAllProducts {
	
	public static void main(String[] args) {
		
		try {
			FileInputStream stream = new FileInputStream("products.properties") ;
			
			Properties prop = new Properties() ;
			prop.load(stream);
			
			String driver = prop.getProperty("driver") ;
			Class.forName(driver) ;
			System.out.println(driver);
			
			String url = prop.getProperty("url") ;
			DriverManager.getConnection(url, prop) ;
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
