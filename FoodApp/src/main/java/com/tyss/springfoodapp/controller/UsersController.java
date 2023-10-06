package com.tyss.springfoodapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.tyss.springfoodapp.dto.Food_Product;
import com.tyss.springfoodapp.dto.Users;
import com.tyss.springfoodapp.service.Food_ProductService;
import com.tyss.springfoodapp.service.UserService;

@Controller
@Component
@Scope(value = "prototype")
@SessionAttributes({"mnguser"})
public class UsersController {
	
	@Autowired
	private UserService service ;
	
	@Autowired
	private Food_ProductService productService ;
	
	@RequestMapping("/singup")
	public ModelAndView signUp() {
		ModelAndView mav = new ModelAndView("signup.jsp");
		mav.addObject("users", new Users()) ;
		return mav ;
	}
	
	@RequestMapping("/saveuser")
	public ModelAndView saveUser(@ModelAttribute Users users) {
		
		String salt = BCrypt.gensalt(6) ;
		String encryptedPassword = BCrypt.hashpw(users.getPassword(), salt) ;
		users.setPassword(encryptedPassword);
		System.out.println(encryptedPassword);
		ModelAndView mav = new ModelAndView("login.jsp") ;
		service.saveUser(users) ;
		return mav ;
	}
	
/*	@RequestMapping("/login")
	public ModelAndView loginUser() {
		ModelAndView mav = new ModelAndView("managerlogin.jsp") ;
		
		ModelAndView mav1 = new ModelAndView("stafflogin.jsp") ;
		ModelAndView mav2 = new ModelAndView("customerlogin.jsp") ;
		
	}*/
	
	@RequestMapping("/managerlogin")
	public ModelAndView managerLogin(Users users, ModelAndView mv) {
		mv.addObject("managerlog", users) ;
		mv.setViewName("managerlogin.jsp");
		return mv;
	}
	
	@RequestMapping("/stafflogin")
	public ModelAndView staffLogin(Users stafflogin, ModelAndView mav) {
		mav.setViewName("stafflogin.jsp") ;
		mav.addObject("stafflogin", stafflogin) ;
		return mav ;
	}
	
	@RequestMapping("/customerlogin")
	public ModelAndView customerLogin() {
		ModelAndView mav = new ModelAndView("customerlogin.jsp") ;
		mav.addObject("customerlogin", new Users()) ;
		return mav ;
	}
	
	
	
	public ModelAndView findAllStaffAndFoodProductgs(ModelAndView mv){
		List<Users> userlist = service.findAllStaff();
		List<Food_Product> prolist = productService.getAllFoodProductService() ;
		mv.addObject("prodlist", prolist) ;
		mv.addObject("userlist", userlist) ;
		mv.setViewName("manageroperation.jsp");
		return mv;
	}
	
	@RequestMapping("/loginmanager")
	public ModelAndView loginManager( ModelAndView mv, HttpServletRequest req) {
		Users user = service.findUserByEmailAndPassword(req.getParameter("email"), req.getParameter("password")  ) ;
		if (user != null ) {
			
			System.out.println("Password is checking");
			
			if (BCrypt.checkpw(req.getParameter("password"), user.getPassword())) {
				
				System.out.println(BCrypt.checkpw(req.getParameter("password"), user.getPassword()));
				
			mv.addObject("mnguser",user);
			mv.addObject("msg", "Manager Login successfull...");
			return findAllStaffAndFoodProductgs(mv) ;
			}
		}
		mv.addObject("msg", "Invalid Credentials...");
		mv.setViewName("managerlogin.jsp");
		return mv;
	}
	
}
