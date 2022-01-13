package com.jsikmc15.virtualbankingrest.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TotalDAO {
	

	
	
	@Autowired
	private SqlSessionTemplate template;



	//auth 계열
	public int insertUserToken(Map map) {
		// TODO Auto-generated method stub
		return template.insert("insertUserToken",map);
	}

	public int insertUserAccount(Map map) {
		// TODO Auto-generated method stub
		return template.insert("insertUserAccount",map);
	}

	public Map selectUserToken(Map map) {
		// TODO Auto-generated method stub
		return template.selectOne("selectUserToken",map);
	}

	public int updateUserToken(Map map) {
		// TODO Auto-generated method stub
		return template.update("updateUserToken",map);
	}
	
	
	
	//account 계열
	
	//계좌 잔액조회
	public Map selelctAccount(Map map) {
		// TODO Auto-generated method stub
		
		return template.selectOne("selectAccount",map);
	}
	
	//계좌 잔액수정
	public int updateBalance(Map map) {
		// TODO Auto-generated method stub
		
		return template.update("updateBalance",map);
	}

	
	//각 계좌정보 조회
	public List<Map> getAllAccounts(Map map) {
		// TODO Auto-generated method stub
		return template.selectList("selectAllAccounts",map);
	}

	public List<Map> getAllTrading(Map map) {
		// TODO Auto-generated method stub
		return template.selectList("selectAllTrading",map);
	}

	public int insertTradingStatement(Map map) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	//transfer 계열

}
