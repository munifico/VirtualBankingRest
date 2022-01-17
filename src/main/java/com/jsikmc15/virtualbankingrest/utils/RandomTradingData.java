package com.jsikmc15.virtualbankingrest.utils;

import java.sql.Date;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class RandomTradingData {
	
	
	
	public static String withdrawData(int balance, int targeter,String msg,Date date) {

		String data = String.format("INSERT INTO trading_statement VALUES (SEQ_TRADING_STATEMENT_NO.NEXTVAL,%s,%s,%s,%s,%s)",targeter,msg,1,"Test 결재",date) ; 				
		return data;
	}
	
	
	public static List withdrawDataPeriod(int balance,int targeter,String msg,int period) {
		List<String> res = new Vector<String>();
		Random rnd = new Random();
		Date date = new Date(System.currentTimeMillis() - rnd.nextInt(13)* 1000*60*60*24);
		new java.sql.Date(date.getTime());
		
		for(int i =0 ; i < rnd.nextInt(10) ; i++ ) {
			res.add(withdrawData(balance, targeter, msg, date));
		}
		
		return res;
	}
	

}
