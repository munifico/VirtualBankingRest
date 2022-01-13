package com.jsikmc15.virtualbankingrest.transfer.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsikmc15.virtualbankingrest.dao.TotalDAO;

@Service("tranferservice")
public class TransferServiceImpl implements TransferService {

	@Autowired
	TotalDAO dao ;
	
	
	@Transactional
	@Override
	public int insertTradingStatement(Map map) throws RuntimeException {
		// TODO Auto-generated method stub
		int affect1 = dao.insertTradingStatement(map);
		
		
		if(affect1 !=0) {
			throw new RuntimeException();
		}
		Map withdraw = new HashMap() ;
		Map deposit = new HashMap() ;
		
		//update user_account SET balance_amt=#{balance} WHERE fintech_use_num=#{fintech_use_num}
		withdraw.put("balance", map.get("balance"));
		withdraw.put("fintech_use_num", map.get("wd_uid"));
		deposit.put("balance", map.get("balance"));
		deposit.put("fintech_use_num", map.get("dps_uid"));
		int affect2 = dao.updateBalance(map);
		int affect3 = dao.updateBalance(map);
		
		return 0;
	}

}
