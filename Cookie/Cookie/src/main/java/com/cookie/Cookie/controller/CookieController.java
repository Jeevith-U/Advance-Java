package com.cookie.Cookie.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookieController {
	
	@GetMapping("/data")
	public String testCookie(@CookieValue String barer) {
		return "My cookie is "+barer;
	}
	
}
