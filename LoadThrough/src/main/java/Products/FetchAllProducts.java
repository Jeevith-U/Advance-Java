package Products;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class FetchAllProducts {
	
	public static void main(String[] args) {
		
		try {
			FileInputStream strem = new FileInputStream("application.properties") ;
			Properties prop = new Properties() ;
			prop.load(strem);
			
			String driver = prop.getProperty("driver") ;
			Class.forName(driver) ;
			
			String url = prop.getProperty("url") ;
			
			Connection con = DriverManager.getConnection(url, prop) ;
			 
			 Statement st = con.createStatement() ;
			 
			 String query = prop.getProperty("query") ;
			 ResultSet set = st.executeQuery(query) ;
			
			 while (set.next()) {
				System.out.println(set.getString(1));
				System.out.println(set.getInt(2));
				System.out.println(set.getString(3));
				System.out.println(set.getInt(4));
				System.out.println(set.getLong(5));
				System.out.println(set.getString(6));
				System.out.println("\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
