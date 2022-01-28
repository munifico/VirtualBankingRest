package com.jsikmc15.virtualbankingrest.transfer.service;

import java.util.List;
import java.util.Map;

import com.jsikmc15.virtualbankingrest.dtos.TradingDTO;

public interface TransferService {

	/*
	 *  해당 서비스 목적 : 거래에 관련된 서비스
	 *  
	 */
	
	//거래처리 
	public int insertTradingStatement(Map map);

	public int insertTestSet(TradingDTO data);
	
	
}
