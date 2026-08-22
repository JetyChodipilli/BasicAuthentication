package com.jt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BasicController {
	
	@GetMapping("/hello")
	public String hello() {
		return "<H1>Healthy</H1>";
		
	}

	@GetMapping("/public")public String publicEndpoint() {
		return "<H1>Public Endpoint</H1>";
	}
}
