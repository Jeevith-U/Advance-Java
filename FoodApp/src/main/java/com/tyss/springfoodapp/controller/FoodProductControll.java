package com.tyss.springfoodapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tyss.springfoodapp.dto.Food_Product;
import com.tyss.springfoodapp.service.Food_ProductService;

@Controller
public class FoodProductControll {
	
	@Autowired
	private Food_ProductService fpsService ;
	
	@Autowired
	private UsersController usersController ;
	
	@RequestMapping("/editfoodproduct")
	public ModelAndView editFoodProduct(@RequestParam int id, ModelAndView mav) {
		mav.addObject("editfpproduct", fpsService.getFood_ProductbyIdService(id)) ;
		mav.setViewName("editfoodproduct.jsp") ;
		return mav ;
	}
	
	@PostMapping("/saveeditedfood")
	public String saveEditedFoodOrder(@ModelAttribute Food_Product product,ModelAndView mav, HttpServletRequest request) {
		fpsService.updateFood_Productervice(product) ;
		return "redirect:/loginmanager" ;
	}
	
	@RequestMapping("/deleteFoodProduct")
	public String deletFoodProduct(@RequestParam int id, HttpServletRequest request,ModelAndView mav) {
		fpsService.deleteFood_Productervice(id) ;
		return "redirect:/loginmanager";
	}
	
}
