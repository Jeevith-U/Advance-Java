package com.tyss.springfoodapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tyss.springfoodapp.dto.Food_Product;

@Controller
public class FoodOrderControll {
	
	@RequestMapping("/saveOrder")
	public ModelAndView saveFoodOrder(@ModelAttribute List<Food_Product> orderlist, ModelAndView mav) {
		return mav;
		
	}
}
