package com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.service.UserService;


@RestController
@RequestMapping (path = "/login")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping
	public String login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		return service.logar(username, pwd).toString();
	}

	
}