package com.jsikmc15.virtualbankingrest.transfer.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

	@PostMapping("/transfer/fin_num")
	public Map doTransaction(@RequestBody Map map) {
		Map result =null;
		return result;
	}
	
}
