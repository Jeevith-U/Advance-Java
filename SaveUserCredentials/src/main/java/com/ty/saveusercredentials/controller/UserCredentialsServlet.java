package com.ty.saveusercredentials.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.saveusercredentials.dao.UserDao;
import com.ty.saveusercredentials.dto.UserEmailAndPassword;

@WebServlet(value = "/savecredentials")
public class UserCredentialsServlet extends HttpServlet{
	
	UserDao dao = new UserDao() ;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserEmailAndPassword user = new UserEmailAndPassword() ;
		
		String email = (String)req.getParameter("email") ;
		String pass = (String)req.getParameter("pass") ;
		
		user.setEmail(email);
		user.setPassword(pass);
		
		System.out.println(user);
		
		dao.saveUserCredentials(user) ;
		
		
	}
}
