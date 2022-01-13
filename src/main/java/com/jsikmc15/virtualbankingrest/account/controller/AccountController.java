package com.jsikmc15.virtualbankingrest.account.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsikmc15.virtualbankingrest.account.service.AccountService;

@RestController
public class AccountController {

	
	@Autowired
	AccountService accountservice;
	
	//인증 및 계쫘 첫 등록을 하는 경우
	@PostMapping(value="/user/account",produces = {"application/json"})
	public Map registNewAccount(@RequestBody Map map) {
		Map result = null;
		
		
		return result;
	}
	
	//인증된 상태에서 계좌를 추가하는 경우
	@PostMapping("/user/account/{count}")
	public Map registOtherAccount(@RequestBody Map map,@PathVariable("count") int count) {
		Map result = null;
		
		
		return result;
	}
	
	
}
