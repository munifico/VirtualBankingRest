package com.jsikmc15.virtualbankingrest.transfer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsikmc15.virtualbankingrest.dao.TotalDAO;
import com.jsikmc15.virtualbankingrest.transfer.service.TransferServiceImpl;
import com.jsikmc15.virtualbankingrest.utils.ResponeCode;

@RestController
public class TransferController {

	@Autowired
	TransferServiceImpl tranferservice;
	
	@Transactional
	@PostMapping("/transfer/fin_num")
	public Map doTransaction(@RequestBody Map map) {
		Map result = new HashMap(); 
		
		int affect = tranferservice.insertTradingStatement(map);
		
		
		if(affect !=1) {
			result.put("resp_code",ResponeCode.ERROR_PARAMETER);
		}else {
			result.put("resp_code",ResponeCode.OK);
		}
		
		return result;
	}
	
}
