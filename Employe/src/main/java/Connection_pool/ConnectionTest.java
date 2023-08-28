package Connection_pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionTest {
	
	public static void main(String[] args) {
		
		 try {
			Class.forName("org.postgresql.Driver") ;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = ConnectionPool.getConnection() ;
		
		String sql = "insert into employe_department values(65, 'Nagesh', 'MD', 9876543)" ;
		
		try {
			Statement st = con.createStatement() ;
			st.execute(sql) ;
			System.out.println("Data inserted ");
			
			ConnectionPool.restoreConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
