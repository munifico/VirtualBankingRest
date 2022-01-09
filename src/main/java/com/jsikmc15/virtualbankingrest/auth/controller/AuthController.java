package com.jsikmc15.virtualbankingrest.auth.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	
	
	@PostMapping("/oauth/token")
	public Map registUser(@RequestBody Map map) {
		Map result = null;
		
		return result;
	}
	

	//인증 및 계쫘 첫 등록을 하는 경우
	@RequestMapping("/user/info")
	public Map registNewAccount(@RequestParam Map map) {
		Map result = null;
		
		
		return result;
	}
	
	//인증된 상태에서 계좌를 추가하는 경우
	@RequestMapping("/user/info/{count}")
	public Map registOtherAccount(@RequestParam Map map,@PathVariable("count") int count) {
		Map result = null;
		
		
		return result;
	}
}
