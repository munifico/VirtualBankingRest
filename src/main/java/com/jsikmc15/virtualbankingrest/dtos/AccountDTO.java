package com.jsikmc15.virtualbankingrest.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {
	 private int no ;
	 private int user_uid;
	 private String fintech_use_num;
	 private String account_num_masked;
	 private String alias;
	 private String account_holder_name;
	 private String bank_name;
	 private String product_name;
	 private String blance_amt;
	 private int account_type;
}
