package MetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaData {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver") ;
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee?user=postgres&password=root") ;
			
			Statement st = con.createStatement() ;
			
			ResultSet rs = st.executeQuery("select * from employe") ;
			
			java.sql.ResultSetMetaData rmd =  rs.getMetaData() ;
			
			System.out.println("Number of column is :" + rmd.getColumnCount());
			
			System.out.println(rmd.getColumnLabel(1));
			
			System.out.println("the 4th column name is :"+rmd.getColumnName(4));
			
			System.out.println("Table name is :"+rmd.getTableName(1));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
