package MetaData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MetaData {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver") ;
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee?user=postgres&password=root") ;
			
			DatabaseMetaData dmd = con.getMetaData() ;
			
			String driver = dmd.getDriverName() ;
			System.out.println(driver);
			
			System.out.println("DataBase product name :" +dmd.getDatabaseProductName());
			
			System.out.println("DataBase product version :"+dmd.getDatabaseProductVersion());
			
			System.out.println("Driver version :"+dmd.getDriverVersion());
			
			System.out.println("joins ? "+dmd.supportsFullOuterJoins());
			
			System.out.println("support transactions :"+dmd.supportsTransactions());
			
			System.out.println("Support stored procedure : "+dmd.supportsStoredProcedures());
			
			System.out.println("Support batch updates :"+dmd.supportsBatchUpdates());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
