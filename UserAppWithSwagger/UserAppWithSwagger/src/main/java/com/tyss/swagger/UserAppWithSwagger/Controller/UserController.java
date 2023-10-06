package com.tyss.swagger.UserAppWithSwagger.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.swagger.UserAppWithSwagger.Entity.User;
import com.tyss.swagger.UserAppWithSwagger.Service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class UserController {
	
	@Autowired
	private UserService service ;
	
	@Operation(description = "To save User Information",summary = "User will be saved in the database")
	@ApiResponses(value = @ApiResponse(description = "User created",responseCode = "201"))
	@PostMapping("/user")
	public void saveUSer(User user) {
		service.saveUser(user) ;
	}

}
