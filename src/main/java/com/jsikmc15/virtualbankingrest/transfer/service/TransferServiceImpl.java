package com.jsikmc15.virtualbankingrest.transfer.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsikmc15.virtualbankingrest.dao.TotalDAO;
import com.jsikmc15.virtualbankingrest.dtos.AccountDTO;
import com.jsikmc15.virtualbankingrest.utils.MyUtils;

@Service("tranferservice")
public class TransferServiceImpl implements TransferService {

	@Autowired
	TotalDAO dao ;
	
	
	@Transactional
	@Override
	public int insertTradingStatement(Map map) throws RuntimeException {
		// TODO Auto-generated method stub
		Map withdraw = new HashMap() ;
		Map deposit = new HashMap() ;

		

		withdraw.put("fintech_use_num", map.get("wd_fintech").toString());
		deposit.put("fintech_use_num", map.get("dps_fintech").toString());
		MyUtils.sout(map);
		int affect_td = dao.insertTradingStatement(map);
		

		int cost = Integer.parseInt(map.get("cost").toString());
		System.out.println("출금이체");;
		AccountDTO wd =dao.selelctAccount(withdraw);
		if(wd.getBalance_amt() < cost) {
			return 3;
		}
		MyUtils.sout(withdraw);
		System.out.println(wd.toString());
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		map = mapper.convertValue(wd,Map.class);
		map.put("balance", wd.getBalance_amt()-cost);
		int affect_wd = dao.updateBalance(map);
		

		
		System.out.println("입금이체");
		AccountDTO dps = dao.selelctAccount(deposit);
		System.out.println(dps.toString());
		deposit.put("balance", dps.getBalance_amt()+cost);
		

		map = mapper.convertValue(dps,Map.class);
		map.put("balance", dps.getBalance_amt()+cost);
		int affect_dps = dao.updateBalance(map);
		

		if(affect_td*affect_dps*affect_td ==0) {
			throw new RuntimeException();
		}
		
		return 1;
	}


	public boolean checkBalance(Map map) {
		// TODO Auto-generated method stub
		
//		Map check = new HashMap();
//		check.put("fintech_use_num",map.get("wd_fintech").toString());
//		Set<String> keys = map.keySet();
//		
//		Map res = dao.selelctAccount(check);
//		
//		keys = res.keySet();
//		for(String key: keys) {
//			System.out.println(key+" - "+res.get(key));
//		}
//		
//		int cost = Integer.parseInt(map.get("cost").toString());
//		map.put("balance_amt", res.get("BALANCE_AMT"));
//		map.put("fintech_use_nume", res.get("FINTECH_USE_NUM"));
//		System.out.println("현재 잔액 : " + res.get("BALANCE_AMT").toString());
//		if(cost > Integer.parseInt(res.get("BALANCE_AMT").toString())) {
//			return false;
//		}
		
		return true;
	}

}
