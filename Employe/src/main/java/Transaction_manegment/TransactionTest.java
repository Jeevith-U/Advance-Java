package Transaction_manegment;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import Connection_pool.ConnectionPool;

public class TransactionTest {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver") ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = ConnectionPool.getConnection() ;
		
		String book = "insert into booking values(1,'INDIGO', 'BLR', 'USA')" ;
		
		String pass1 = "insert into passenger values(12, 'Jai', 27, 'Male')" ;
		
		String pass2 = "insert into passenger values(22, 'Jeevith', 22, 'Male')" ;
		
		String pass3 = "insert into passenger values(32, 'Jee', 24, 'Male')" ;
		
		String payment = "insert into payment values(42, 3, 65000, 3500, 'pending')" ;
		
		try {
			Statement st1 = con.createStatement() ;
			st1.execute(book) ;
			
			Savepoint savepoint = con.setSavepoint() ;
			
			Statement st2 = con.createStatement() ;
			st2.execute(pass1) ;
			
			Statement st3 = con.createStatement() ;
			st3.execute(pass2) ;
			
			Statement st4 = con.createStatement() ;
			st4.execute(pass3) ;
			
			if (DemoPaymentGateway.isSuccess()) {
				Statement st5 = con.createStatement() ;
				st5.execute(payment) ;
				con.commit();
				System.out.println("tickets booked");
			}else {
				con.rollback(savepoint);
				con.commit();
				System.out.println("tickets are not booked");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
