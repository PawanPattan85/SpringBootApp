package com.springBoot.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@GetMapping("/home")
	@Secured(value="ROLE_USER")
	public String getData(){
		return "hello";
	}
	
}
