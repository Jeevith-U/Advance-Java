package com.ty.studentpp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/hi")
	public String sayHi() {
		return "index.jsp" ;
	}
	
	@GetMapping("hi2")
	public String balaya() {
		return "page2.jsp" ;
	}

}
