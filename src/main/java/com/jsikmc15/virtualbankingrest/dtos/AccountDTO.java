package com.jsikmc15.virtualbankingrest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Data
public class AccountDTO {
	private int no ;
	private int user_uid;
	private String fintech_use_num;
	private String account_num_masked;
	private String alias;
	private String account_holder_name;
	private String bank_name;
	private String product_name;
	private Long balance_amt;
	private int account_type;
	 
	public AccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AccountDTO [no=" + no + ", user_uid=" + user_uid + ", fintech_use_num=" + fintech_use_num
				+ ", account_num_masked=" + account_num_masked + ", alias=" + alias + ", account_holder_name="
				+ account_holder_name + ", bank_name=" + bank_name + ", product_name=" + product_name + ", balance_amt="
				+ balance_amt + ", account_type=" + account_type + "]";
	}
	
	 
}
