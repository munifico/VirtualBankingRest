package com.jsikmc15.virtualbankingrest.auth.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	

	@PostMapping("/oauth/token")
	public Map registUser(@RequestBody Map map) {
		Map result = null;
		
		return result;
	}
}
