package com.jsikmc15.virtualbankingrest.account.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.jsikmc15.virtualbankingrest.dao.TotalDAO;

public class AccountServiceImpl implements AccountService{

	@Autowired
	TotalDAO dao;
	
	@Override
	public Map getAllAccounts(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getAccount(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

}
