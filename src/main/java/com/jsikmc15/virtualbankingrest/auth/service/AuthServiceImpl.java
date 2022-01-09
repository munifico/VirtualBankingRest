package com.jsikmc15.virtualbankingrest.auth.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsikmc15.virtualbankingrest.dao.TotalDAO;
import com.jsikmc15.virtualbankingrest.utils.ResponeCode;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	TotalDAO dao;
	
	@Override
	public int registNew(Map map) {
		// TODO Auto-generated method stub
		
		//유저 토큰 등록
		int affected1 = dao.insertUserToken(map);
		
		
		//유저 계좌 등록
		int affected2 = dao.insertUserAccount(map);
		
		
		
		return affected1 * affected2;
		
	}

	@Override
	public int registOther(Map map) {
		// TODO Auto-generated method stub
		
		//해당 토큰으로 된 유저 계좌 검색
		Map data = dao.selectUserAccount(map);
		
		
		//유저 토큰 업데이트 
		int affected1 = dao.updateUserToken(map);

		//현재 map으로 넘어온 계좌들 중에서 새로 추가된 계좌확인 후 
		
		
		//해당 계좌를 유저 계좌 추가
		int affected2 = dao.insertUserAccount(map);
		
		
		return affected1*affected2;
	}

	@Override
	public boolean checkToken(String token) {
		// TODO Auto-generated method stub
		return false;
	}

}
