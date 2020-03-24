package com.test.springboot.todo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.springboot.todo.model.AuthenticateBean;
import com.test.springboot.todo.model.ServerBean;

@RestController
@CrossOrigin("http://localhost:4200")
public class BasicAuthController {


	@GetMapping("/basicAuth")
	public AuthenticateBean authenticate() {

		return new AuthenticateBean("Authenticated");
	}


}
