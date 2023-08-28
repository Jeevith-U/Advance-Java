package org.ty.Product.project.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import org.ty.Product.Products.Products;
import org.ty.Product.project.exception.IDNotFoundException;

public class ProductDao {
	
	Scanner sc = new Scanner(System.in) ;
	
	static Connection con;

	static {

		try {
			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/products?user=postgres&password=root");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void saveProduct(Products p) {

		try {
			CallableStatement st = con.prepareCall("call product_procedure (?,?,?,?,?,?)");
			st.setInt(1, p.getId());
			st.setString(2, p.getName());
			st.setString(3, p.getType());
			st.setString(4, p.getDescription());
			st.setString(5, p.getAvailability());
			st.setDouble(6, p.getPrice());

			st.execute();
			System.out.println("Product inserted to the DB");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Products findByProductId(int id) {
		
		Products products = new Products() ;
		try {
			CallableStatement st = con.prepareCall("call product_fetch (?,?,?,?,?,?)");

			st.setInt(1, id);
			st.registerOutParameter(1, Types.INTEGER);
			st.registerOutParameter(2, Types.VARCHAR);
			st.registerOutParameter(3, Types.VARCHAR);
			st.registerOutParameter(4, Types.VARCHAR);
			st.registerOutParameter(5, Types.VARCHAR);
			st.registerOutParameter(6, Types.DOUBLE);

			st.execute();
			if(st.getInt(1)!=0) {
			products.setId(st.getInt(1));
			products.setName(st.getString(2));
			products.setType(st.getString(3));
			products.setDescription(st.getString(4));
			products.setAvailability(st.getString(5));
			products.setPrice(st.getDouble(6));
			}
			else {
				System.out.println("no record found");
				return null;
			}
			
//			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;

	}

	public Products updateProductById(Products p) {
		try {
			CallableStatement st = con.prepareCall("call product_updation (?,?)");
			int did = p.getId() ;
			double pre = p.getPrice() ;
			p = findByProductId(did) ;
			if(p.getId()!=0) {
				st.setInt(1, did);
				st.setDouble(2, pre);
				st.execute() ;
				con.close();
			}
			else {
				throw new IDNotFoundException("ID not present in the database ") ;
			}
			/*p.setId(produ.getId());
			p.setName(produ.getName());
			p.setType(produ.getType());
			p.setDescription(produ.getDescription());
			p.setAvailability(produ.getAvailability());*/
			
			p.setPrice(p.getPrice());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;

	}

	public void removeProductById(int id) {

		try {
			CallableStatement st = con.prepareCall("call product_deletion (?)");
			st.setInt(1, id);
			st.execute();
			System.out.println("product with the id " + id + "deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
