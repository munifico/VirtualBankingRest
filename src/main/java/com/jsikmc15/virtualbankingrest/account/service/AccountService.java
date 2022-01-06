package com.jsikmc15.virtualbankingrest.account.service;

import java.util.Map;

public interface AccountService {
	
	/*
	 *  해당 서비스 목적 : 가지고 있는 계좌를 조회 혹은 특정계좌의 잔액을 조회하기 위한 서비스
	 *  
	 */
	
	//모든 계좌 조회
	public Map getAllAccounts(Map map);
	
	//특정 계좌 정보 조회
	public Map getAccount(Map map);
	
}
