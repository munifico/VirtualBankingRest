package com.jsikmc15.virtualbankingrest.transfer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsikmc15.virtualbankingrest.dao.TotalDAO;
import com.jsikmc15.virtualbankingrest.utils.ResponeCode;

@RestController
public class TransferController {

	@Autowired
	TotalDAO dao;
	
	@Transactional
	@PostMapping("/transfer/fin_num")
	public Map doTransaction(@RequestBody Map map) {
		Map result =new HashMap();
		
		//계좌 조회
		Map withdraw = dao.selectAccountByFin(map);
		Map deposit = dao.selectAccountByFin(map);
		
		
		if(withdraw ==null || deposit ==null) {
			result.put("resp_code",ResponeCode.ERROR);
			return result
		}
		
//		if(widthdraw.get)
		
		
		
		return result;
	}
	
}
