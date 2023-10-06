package com.tyss.springfoodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.tyss.springfoodapp.dto.Food_Product;
import com.tyss.springfoodapp.dto.Users;
import com.tyss.springfoodapp.service.Food_ProductService;
import com.tyss.springfoodapp.service.UserService;

@Controller
@SessionAttributes({"staffuser"})
public class StaffController {
	
	@Autowired
	private UserService userService ;
	
	@Autowired
	private Food_ProductService fpsService ;
	
	@RequestMapping("/validateStaff")
	public ModelAndView loginCustomer(@RequestParam("email") String email,
			@RequestParam("password") String password, ModelAndView mav/* , List<Food_Product> orderlist */) {
		
		Users staffUser = userService.findUserByEmailAndPassword(email, password) ;
		
		if (staffUser != null && staffUser.getRole().equalsIgnoreCase("staff")) {
			
			mav.addObject("staffuser", staffUser) ;
			mav.setViewName("staffoperation.jsp") ;
//			mav.addObject("orderlist", orderlist) ;
			mav.addObject("productList", fpsService.getAllFoodProductService()) ;
			return mav ;
			
		}else
			mav.setViewName("stafflogin.jsp") ;
			mav.addObject("msg", "Invalid Credentials check Email And Password") ;
		return mav;
	}
	
}
