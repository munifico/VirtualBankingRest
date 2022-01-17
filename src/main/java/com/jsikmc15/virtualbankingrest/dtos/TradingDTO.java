package com.jsikmc15.virtualbankingrest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Data
public class TradingDTO {
	 private int no;
	 private int wd_uid;
	 private String wd_print_content;
	 private int dps_uid;
	 private int dps_print_content;
	 private int tran_amt;
	 private java.sql.Date tranDate;
	 private String res_code;
	public TradingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
}
