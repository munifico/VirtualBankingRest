package com.jsikmc15.virtualbankingrest.account.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.jsikmc15.virtualbankingrest.dao.TotalDAO;
import com.jsikmc15.virtualbankingrest.utils.ResponeCode;

public class AccountServiceImpl implements AccountService{

	@Autowired
	TotalDAO dao;

	
	//유저 전 계좌 조회
	@Override
	public Map getAllAccounts(Map map) {
		// TODO Auto-generated method stub
		Map result = new HashMap();

		return result;
	}

	
	//유저 잔액 조회
	@Override
	public Map getAccount(Map map) {
		// TODO Auto-generated method stub
		Map result = dao.selelctAccount(map);
		
		if(result==null) {
			result.put("resp_code", ResponeCode.ERROR);
		}else {
		
			result.put("resp_code", ResponeCode.OK);
			
		}
		
		return result;
	}

}
