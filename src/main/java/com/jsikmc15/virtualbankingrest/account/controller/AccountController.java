package com.jsikmc15.virtualbankingrest.account.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

	@RequestMapping("/sample/auth")
	public String sampleAuth(@RequestParam Map map) {
		
		return "/";
	}
}
