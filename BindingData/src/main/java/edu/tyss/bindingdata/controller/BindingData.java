package edu.tyss.bindingdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BindingData {
	
	@GetMapping("/info")
	public String printName(Model model) {
		
		model.addAttribute("myName", "Jeevith") ;
		model.addAttribute("anime", "One Piece") ;
		model.addAttribute("bounty", "3B") ;
		
		return "student.jsp";
		}
}
