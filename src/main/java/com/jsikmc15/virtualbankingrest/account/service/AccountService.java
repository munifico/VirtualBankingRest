package com.jsikmc15.virtualbankingrest.account.service;

import java.util.List;
import java.util.Map;

import com.jsikmc15.virtualbankingrest.dtos.AccountDTO;
import com.jsikmc15.virtualbankingrest.dtos.TradingDTO;

public interface AccountService {
	
	/*
	 *  해당 서비스 목적 : 가지고 있는 계좌를 조회 혹은 특정계좌의 잔액을 조회하기 위한 서비스
	 *  
	 */
	
	//모든 계좌 조회
	public List<Map> getAllAccounts(Map map);
	
	//특정 계좌 정보 조회
	public Map getAccount(Map map);
	
	//현 계좌 거래 내역 조회
	public List<Map> getAllTrading(Map map);
	
	//거래로인한 잔액 수정
	public int updateBalance(Map map);

	
	
}
