package edu.tyss.modelandview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@GetMapping("/page1")
	public ModelAndView viewPage1() {
		ModelAndView view = new ModelAndView("page1.jsp") ;
		view.addObject("King", "Raja Vikrama") ;
		view.addObject("queen", "Gangamahadevi") ;
		return view ;
	}
}
