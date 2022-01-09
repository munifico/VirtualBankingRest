package com.jsikmc15.virtualbankingrest.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDTO {
	 private int no ;
	 private String access_token;
	 private int expires_in;
	 private String refresh_token;
	 private String token_scope;
	 private String user_seq_no;
	 private String user_ci;
	 private String name;
	 private int user_type;
}
