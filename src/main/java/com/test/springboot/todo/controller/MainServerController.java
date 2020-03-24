package com.test.springboot.todo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.springboot.todo.model.ServerBean;

@RestController
@CrossOrigin("http://localhost:4200")
public class MainServerController {

	@GetMapping("/test")
	public String testServer() {

		return "Server is Up and Runing";
	}

	@GetMapping("/testBean")
	public ServerBean testServerBean() {

		return new ServerBean("Test Server Bean");
	}

	@GetMapping("/testBean/param/{value}")
	public ServerBean testServerPV(@PathVariable String value) {

		return new ServerBean("Test Server Bean - "+value);
	}

}
