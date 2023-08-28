package edu.ty.customer.view;

import edu.ty.customer.controller.DAO;

public class View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DAO dao=new DAO();
//		dao.createUser();
		dao.updateCustomerNameById(1, "shima");
	}

}
