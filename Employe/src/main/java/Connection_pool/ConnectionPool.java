package Connection_pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	
	private static List<Connection> al = new ArrayList<Connection>() ;
	private static final int pool_size = 5 ;
	
	static {
		try {
			Class.forName("org.postgresql.Driver") ;
			
			for (int i = 0; i < pool_size ; i++) {
				Connection connection = createConnection() ;
				al.add(connection) ;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*this method receive the connection returned from the user after usage
	 * and add it the list 
	 * if the size is exceeded it will kill the connection  */
	public static void restoreConnection(Connection connection) {
		if (al.size() < pool_size) {
			al.add(connection) ;
		} else
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	/*when this method is called it taking the connection from list and giving it to the caller
	 * this method using the connection created by the createConnection() method 
	 * it is not creating any connection*/
	public static Connection getConnection() {
		if (!al.isEmpty()) {
			return al.remove(0) ;
		}else
		return createConnection();
	}
	
	
	
	/* this method is creating the connection and storing it in the list 
	 * But this method is giving the connection to anyone
	 * */
	private static Connection createConnection() {
		Connection connection = null ;
		try {                                                                  //change employee db if u want to execute current program
			 connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transaction?user=postgres&password=root") ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
