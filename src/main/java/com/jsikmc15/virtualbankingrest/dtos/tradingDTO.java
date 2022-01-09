package com.jsikmc15.virtualbankingrest.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class tradingDTO {
	 private int no;
	 private int wd_uid;
	 private String wd_print_content;
	 private int dps_uid;
	 private int dps_print_content;
	 private int tran_amt;
	 private java.sql.Date traDate;
}
