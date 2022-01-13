package com.jsikmc15.virtualbankingrest.account.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsikmc15.virtualbankingrest.dao.TotalDAO;
import com.jsikmc15.virtualbankingrest.utils.ResponeCode;

@Service("accountservice")
public class AccountServiceImpl  implements AccountService{

	@Autowired
	TotalDAO dao;

	
	//유저 전 계좌 조회
	@Override
	public List<Map> getAllAccounts(Map map) {
		// TODO Auto-generated method stub
		List<Map> result = dao.getAllAccounts(map);

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


	@Override
	public List<Map> getAllTrading(Map map) {
		// TODO Auto-generated method stub
		return dao.getAllTrading(map);
	}


	@Override
	public int updateBalance(Map map) {
		// TODO Auto-generated method stub
		return dao.updateBalance(map);
	}
	
	

}
