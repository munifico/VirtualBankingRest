package com.jsikmc15.virtualbankingrest.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsikmc15.virtualbankingrest.dtos.AccountDTO;

@Repository
public class TotalDAO {
	

	
	
	@Autowired
	private SqlSessionTemplate template;



	//auth 계열
	public int insertUserToken(Map map) {
		
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(key+" - "+map.get(key));
		}
		
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
		int tmp = template.update("updateUserToken",map);
		System.out.println("결과 : "+tmp);
		return tmp;
	}
	
	
	
	//account 계열
	
	//계좌 잔액조회
	public AccountDTO selelctAccount(Map map) {
		// TODO Auto-generated method stub
		System.out.println("????>>"+map.get("fintech_use_num"));
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
		return template.insert("insertTradingStatement",map);
	}

	
	//seq를 중심으로 확인
	public int selectConfirmUser(Map map) {
		// TODO Auto-generated method stub
//		System.out.println("아니 없어 ? "+ map.get("user_seq_no"));
		return template.selectOne("selectConfirmUser",map);
	}
	
	
	
	//transfer 계열

}
