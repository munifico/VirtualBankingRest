package com.jsikmc15.virtualbankingrest.auth.service;

import java.util.Map;

public interface AuthService {

	/*
	 *  해당 서비스 목적 : 인증 토큰을 통해 각 정보들을 받아 등록하거나 변경사항이 있을 경우(계좌를 추가하는경우), 변경사항에 대해서 수정한다.
	 *  
	 */
	
	//토큰 및 계좌 등록
		public int registNew(Map map);
	//토큰 변경
		public int registOther(Map map);
		
	//인증 신청
		public Map getAuthUrl(Map map);
		
		//토큰 등록
		public Map setToken(Map map);
		
		//계좌 조회
		public Map getAccountOpenBaking(Map map);
		
		public boolean isUser(Map map);
}
