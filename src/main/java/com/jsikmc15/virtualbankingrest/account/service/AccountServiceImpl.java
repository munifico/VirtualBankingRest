package com.jsikmc15.virtualbankingrest.account.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.jsikmc15.virtualbankingrest.dao.TotalDAO;
import com.jsikmc15.virtualbankingrest.dtos.AccountDTO;
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

		Set<String> keys = map.keySet();
		for(String key: keys) {
			System.out.println(key+" - "+map.get(key));
		}
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		return mapper.convertValue(dao.selelctAccount(map),Map.class);
	}


	@Override
	public List<Map> getAllTrading(Map map) {
		// TODO Auto-generated method stub

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		//return dao.getAllTrading(map);
		return mapper.convertValue(dao.getAllTrading(map),
				TypeFactory.defaultInstance().constructCollectionType(List.class, Map.class));
	}


	@Override
	public int updateBalance(Map map) {
		// TODO Auto-generated method stub
		return dao.updateBalance(map);
	}

	
	

}
