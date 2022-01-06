package com.jsikmc15.virtualbankingrest.account.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsikmc15.virtualbankingrest.dtos.AccountDTO;
import com.jsikmc15.virtualbankingrest.dtos.UserDTO;

@RestController
public class AccountController {

	
	//사용자 정보 조회 (전체 계좌포함)
	@GetMapping("/user/me")
	@ResponseBody
	public UserDTO getUserInfo(Map map) {
		UserDTO user=null;
			
		return user;
	}
	
	
	//사용자 특정 계좌 조회
	@GetMapping("/balance/fin_num")
	@ResponseBody
	public AccountDTO getAccountInfo(Map map) {
		AccountDTO account=null;
			
		return account;
	}
	
}
