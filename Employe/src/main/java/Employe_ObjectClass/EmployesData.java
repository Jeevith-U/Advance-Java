package Employe_ObjectClass;

import java.awt.Window.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.Scanner;

public class EmployesData {

	static Connection con;

	static {

		try {
			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee?user=postgres&password=root");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Scanner sc =  new Scanner(System.in) ;
		Employe e = new Employe();
		System.out.println("Select the operation you want to perform\n1.Insert User\n2.Find User\n3.Update User\n4.Delete User");
		int operation = sc.nextInt() ;
		
		switch (operation) {
		case 1:
			saveEmploye(e);
			break;
			
		case 2 :
		    System.out.println("Enter the id you want to fetch");
		    int fid = sc.nextInt() ;
		    fetchEmployeById(e,fid) ;
		    break ;
		    
		case 3:
			System.out.println("Enter the id you want to update ");
			int id = sc.nextInt() ;
			UpdateEmployeById(e, id) ;
			break;
			
		case 4:
			System.out.println("Enter the id you want to delete");
			int did = sc.nextInt() ;
			deleteEmployeById(e, did) ;
			break;
		}
	}
	
	public static void fetchEmployeById(Employe e, int fid) {
		
		try {
			CallableStatement cst = con.prepareCall("call fetchall_employes(?,?,?,?,?,?,?)") ;
			
			cst.setInt(1, e.setEmp_id(fid));
			cst.registerOutParameter(1, Types.INTEGER);
			cst.registerOutParameter(2, Types.VARCHAR);
			cst.registerOutParameter(3,  Types.VARCHAR);
			cst.registerOutParameter(4, Types.BIGINT);
			cst.registerOutParameter(5, Types.VARCHAR);
			cst.registerOutParameter(6, Types.BIGINT);
			cst.registerOutParameter(7, Types.VARCHAR);
			
			cst.execute() ;
			
			System.out.println("id : "+ cst.getInt(1));
			System.out.println("name : "+ cst.getString(2));
			System.out.println("designation : "+ cst.getString(3));
			System.out.println("phone number : "+ cst.getLong(4));
			System.out.println("department: "+ cst.getString(5));
			System.out.println("salary : "+ cst.getLong(6));
			System.out.println("password : "+ cst.getString(7));
			
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public static void deleteEmployeById(Employe e, int id) {
		
		try {
			CallableStatement cst = con.prepareCall("call delete_emp(?)") ;
			cst.setInt(1, e.setEmp_id(id));
			cst.execute() ;
			System.out.println("deleted "+id+ " from the database");
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	public static void UpdateEmployeById(Employe e, int id) {
		
		try {
			
			CallableStatement cst = con.prepareCall("call update_emp(?, ?)") ;
			
			cst.setInt(1, id );
			cst.setString(2, e.setEmp_name("cheef Cleaner"));
			
			cst.execute() ;
			
			System.out.println("Data updated");
			
			cst.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public static void saveEmploye(Employe e) {

		try {

			CallableStatement cst = con.prepareCall("call employe_stored_procedure (?,?,?,?,?,?,?)");

			cst.setInt(1, e.setEmp_id(32));
			cst.setString(2, e.setEmp_name("john"));
			cst.setString(3, e.setEmp_designation("iot developer"));
			cst.setLong(4, e.setEmp_ph_no(879236846));
			cst.setString(5, e.setEmp_dept("HardWare"));
			cst.setLong(6, e.setEmp_sal(900000));
			cst.setString(7, e.setEmp_pass("john@iot"));

			cst.execute();
			System.out.println("Data inserted !");
			
			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
}
