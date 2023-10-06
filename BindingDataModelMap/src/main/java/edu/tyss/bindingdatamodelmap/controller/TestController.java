package edu.tyss.bindingdatamodelmap.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@GetMapping("/luffy")
	public String showMessage(ModelMap map) {
		
		map.put("arc", "wanokuni") ;
		map.put("villan", "Kaido") ;
		
		Map<String, Double> map2 = new LinkedHashMap <String, Double>() ;
		map2.put("value", 1.2122);
		map2.put("value1", 76347.376463) ;
		map2.put("value2", 52365326.0) ;
		
		map.addAllAttributes(map2) ;
		return "onepiece.jsp" ;
	}
	
	
}
