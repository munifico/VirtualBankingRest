package com.jsikmc15.virtualbankingrest.utils;

import java.util.Map;
import java.util.Set;

import com.jsikmc15.virtualbankingrest.dtos.TokenDTO;

public class MyUtils {
	
	public static void sout(Map map) {
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(key+" - " + map.get(key));
		}
	}
	
}
