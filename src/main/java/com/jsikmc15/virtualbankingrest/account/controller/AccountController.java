package com.jsikmc15.virtualbankingrest.account.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsikmc15.virtualbankingrest.account.service.AccountService;
import com.jsikmc15.virtualbankingrest.auth.service.AuthService;
import com.jsikmc15.virtualbankingrest.utils.MyUtils;
import com.jsikmc15.virtualbankingrest.utils.ResponeCode;

@RestController
public class AccountController {

	
	@Autowired
	AccountService accountservice;
	@Autowired
	AuthService authservice;
	
	//계좌 전체 목록조회
	@GetMapping(value="/user/account",produces = {"application/json"})
	public Map getAllAccounts(@RequestParam Map map,
			@RequestHeader(value="Authorization",defaultValue = "Barear NONE")String authorization,
			@RequestHeader Map user) {
		StringTokenizer stk = new StringTokenizer(authorization);
		stk.nextToken();
		String token = stk.nextToken();
		MyUtils.sout(user);
		System.out.println("토큰 : " + token);
		System.out.println("파라미터 체크 : " + user.get("user_seq_no"));
		//토큰 검증로직 넣을 거면 여기에 넣을 것
		Map result = new HashMap();
		//유저가 맞는 경우 
		if(authservice.isUser(user)) {
			result.put("resp_code",ResponeCode.OK);
			result.put("res_list", accountservice.getAllAccounts(user));
		}else {
			result.put("resp_code",ResponeCode.ERROR);
		}

		return result;
	}
	
	//계좌 목록중 하나 조회
	@GetMapping("/user/account/{fin_num}")
	public Map getAccount(@RequestParam Map map,@PathVariable("fin_num") String count,
			@RequestHeader(value="Authorization",defaultValue = "Barear NONE")String authorization,
			@RequestHeader(value="user_seq_no") String user_seq_no) {
		StringTokenizer stk = new StringTokenizer(authorization);
		stk.nextToken();
		String token = stk.nextToken();
		map.put("user_seq_no", user_seq_no);
		map.put("fintech_use_num", String.valueOf(count));
		System.out.println("캐시때문인가?"+map.get("fintech_use_num"));
		//토큰 검증로직 넣을 거면 여기에 넣을 것
		Map result = new HashMap();
		//유저가 맞는 경우 
		if(authservice.isUser(map)) {
			
			
			result =accountservice.getAccount(map);
			result.put("resp_code",ResponeCode.OK);
		}else {
			result.put("resp_code",ResponeCode.ERROR);
		}
		
		return result;
	}
	
	
	
	//거래내역 조회
	@GetMapping("/user/account/trading")
	public Map getBalance(@RequestParam Map map,
			@RequestHeader(value="Authorization",defaultValue = "Barear NONE") String authorization,
			@RequestHeader(value="user_seq_no") String user_seq_no,
			@RequestHeader(value="fintech_use_num") String fintech_use_num) {
		StringTokenizer stk = new StringTokenizer(authorization);
		stk.nextToken();
		String token = stk.nextToken();

		map.put("user_seq_no", user_seq_no);
		map.put("fintech_use_num", fintech_use_num);
		Map result = new HashMap();
		if(token.equals("NONE")) {
			Map res = new HashMap();
			res.put("resp_code", ResponeCode.ERROR_AUTHTOKEN);
			return res;
		}
		
		MyUtils.sout(map);
		//유저가 맞는 경우 
		if(authservice.isUser(map)) {
			List<Map>res_list = accountservice.getAllTrading(map);
			result.put("resp_code",ResponeCode.OK);
			result.put("res_list", res_list);
			return result;
			
			
		}else {
			result.put("resp_code", ResponeCode.ERROR_AUTHTOKEN);
			
		}
		
		
		
		
		
		return result;
	}
	
	
}
