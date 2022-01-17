package com.jsikmc15.virtualbankingrest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TokenDTO {
	 private int no ;
	 private String access_token;
	 private int expires_in;
	 private String refresh_token;
	 private String scope;
	 private String user_seq_no;
	 private String user_ci;
	 private String name;
	 private int user_type;
	 
	 
	@Override
	public String toString() {
		return "TokenDTO [no=" + no + ", access_token=" + access_token + ", expires_in=" + expires_in
				+ ", refresh_token=" + refresh_token + ", token_scope=" + scope + ", user_seq_no=" + user_seq_no
				+ ", user_ci=" + user_ci + ", name=" + name + ", user_type=" + user_type + "]";
	}


	public TokenDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
