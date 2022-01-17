package com.jsikmc15.virtualbankingrest.transfer.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jsikmc15.virtualbankingrest.account.service.AccountService;
import com.jsikmc15.virtualbankingrest.dao.TotalDAO;
import com.jsikmc15.virtualbankingrest.transfer.service.TransferServiceImpl;
import com.jsikmc15.virtualbankingrest.utils.ResponeCode;

@RestController
public class TransferController {

	@Autowired
	TransferServiceImpl tranferservice;
	@Autowired
	AccountService accountservice;
	
	
	@PostMapping(value ="/transfer/fin_num",produces = {"application/json"})
	public Map doTransaction(@RequestBody Map map,@RequestHeader(value="Authorization",defaultValue = "Barear NONE")String authorization) {
		

		Map result = new HashMap(); 
		//인증 토큰 확인
		if(authorization.split(" ")[0].equals("NONE")) {
			result.put("resp_code", ResponeCode.ERROR_AUTHTOKEN);
			return result;
		}
		
		//인출자의 계좌를 조회하여, 금액이 충분한지 확인한다.

			//충분하다면, 서비스를 수행한다.
		int affect = tranferservice.insertTradingStatement(map);
		if(affect ==3) {
			result.put("resp_code",ResponeCode.ERROR_LACKOFBALANCE);	
			
		}else if(affect ==0){
			result.put("resp_code",ResponeCode.ERROR);
		}else {
			result.put("resp_code",ResponeCode.OK);
		}
		
		
		return result;
	}
	
}
