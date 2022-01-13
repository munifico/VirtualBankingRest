package com.jsikmc15.virtualbankingrest.auth.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsikmc15.virtualbankingrest.auth.service.AuthService;
import com.jsikmc15.virtualbankingrest.utils.ResponeCode;

@RestController
public class AuthController {

	@Autowired
	AuthService authservice;
	
	@PostMapping("/oauth/token")
	public Map registUser(@RequestBody Map map) {
		Map result = null;
		
		return result;
	}
	

	//인증 및 계좌 첫 등록을 하는 경우
	@PostMapping(value="/user/info",produces = {"application/json"})
	public Map registNewAccount(@RequestBody Map<String,String> map) {
		Map result = new HashMap();
		for(Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
		
		int affect =authservice.registNew(map);
		
		if(affect !=0) {
			result.put("resp_code",ResponeCode.OK);
		}else {
			result.put("resp_code",ResponeCode.ERROR);
		}
		return result;
	}
	
	//인증된 상태에서 계좌를 추가하는 경우
	@PostMapping("/user/info/{count}")
	public Map registOtherAccount(@RequestParam Map map,@PathVariable("count") int count) {
		Map result = new HashMap();
		int affect =authservice.registOther(map);
		
		if(affect !=0) {
			result.put("resp_code",ResponeCode.OK);
		}else {
			result.put("resp_code",ResponeCode.ERROR);
		}
		return result;
	}
}
