package com.tyss.springfoodapp.controller;



import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.tyss.springfoodapp.dto.Food_Product;
import com.tyss.springfoodapp.dto.Users;
import com.tyss.springfoodapp.service.Food_ProductService;
import com.tyss.springfoodapp.service.UserService;

@Controller
@SessionAttributes()
public class ManagerController {
	
	@Autowired
	private Users newUser ;
	
	@Autowired
	private UserService service ;
	
	@Autowired
	private Food_ProductService prodService ;
	
	@Autowired
	private UsersController usersController ;
	
	@RequestMapping("/createstaff")
	public ModelAndView gotoCreateStaff(ModelAndView mav,Users staff) {
		mav.addObject("staff", staff) ;
		mav.setViewName("createstaff.jsp") ;
		return mav;
	}
	
	@RequestMapping("/savestaff")
	public ModelAndView savestaffCreateByManager(@ModelAttribute Users staffusers, ModelAndView mav,HttpServletRequest request) {
		if (staffusers != null) {
			staffusers.setRole("STAFF") ;
			mav.addObject("msg", "Staff Saved Sucessfully") ;
			service.saveUser(staffusers) ;
			return usersController.loginManager( mav, request) ;
		}
		mav.addObject("failedstaff","Unable to save the staff") ;
		mav.setViewName("createstaff.jsp") ;
		return mav;
	}
	
	@RequestMapping("/createfoodproduct")
	public ModelAndView createFoodProduct(Food_Product product, ModelAndView mav) {
		mav.addObject("createFoodProduct", product);
		mav.setViewName("createfoodproduct.jsp") ;
		return mav ;
	}
	
	@RequestMapping("/saveFoodProduct")
	public ModelAndView saveFoodProductCreatedByManager(@ModelAttribute Food_Product product, ModelAndView mav, HttpServletRequest request) {
		if (product != null) {
			prodService.saveFood_Productervice(product) ;
			mav.addObject("prodsaved", "Successfully saved the food product") ;
			return usersController.loginManager( mav, request) ;
		}
		mav.addObject("msg", "Unable To create the Food Product Retry") ;
		mav.setViewName("createfoodproduct.jsp") ;
		return mav;
	}
	
	@RequestMapping("/editstaffdetails")
	public ModelAndView editStaffDetails(HttpServletRequest req, ModelAndView mav) {
		int id = Integer.parseInt(req.getParameter("id"));
		mav.setViewName("editstaff.jsp") ;
		mav.addObject("editstaffdetails", service.findUser(id)) ;
		return mav ;
	}
	
	@RequestMapping("/saveEditStaffDetails")
	public ModelAndView saveEditEmployeeDetails(@ModelAttribute Users uuser, ModelAndView mav) {
		System.out.println(uuser.getId());
		service.updateUser(uuser) ;
		return usersController.findAllStaffAndFoodProductgs(mav) ;
	}
	
	@RequestMapping("/deletestaff")
	public ModelAndView deleteStaff(@RequestParam int id, ModelAndView mav, HttpServletRequest request) {
		service.deleteUser(id) ;
		return usersController.findAllStaffAndFoodProductgs(mav) ;
	}
}
