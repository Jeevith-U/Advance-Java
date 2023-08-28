
/*
 * in batch execution we can execute several/ diffeqrent data of same type of a same queries 
 * but we can't execute different queries in a batch 
 * 
 * from java 8 if declare the the connection in the separate try resource the compiler will close the resource it self 
 * 
 */

package org.tyss.userDao.BatchExecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchExecutionAndFinallyBlock {
	
	 public static void main(String[] args) {
		 
		 Connection con = null;
		
		 try {
			Class.forName("org.postgresql.Driver") ;
			
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop?user=postgres&password=root") ;
			
			PreparedStatement pst = con.prepareStatement("update newuser set phno = ? where phno = ?") ;
			
			pst.setLong(1, 22222222) ;
			pst.setLong(2, 99002486) ;
			pst.addBatch() ;
			System.out.println("updated successfully");
			
			PreparedStatement st = con.prepareStatement("delete form newuser where id = ?") ;
			st.setInt(1, 322) ;
			st.addBatch() ;
			System.out.println("deleted successfully ");
			
			pst.executeBatch() ;
			st.execute() ;
			System.out.println("Batch alterd ! ");
			
//			con.close() ;
		}
		 
		 catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		 
		 finally {
				if (con != null ) {
					try {
						con.close() ;
					} catch (SQLException e) {
						
						/* even if problem  occur in the middle because of finally block 
						the connection will be closed */
						
						e.printStackTrace();
					}
				}
			}
	}
}
