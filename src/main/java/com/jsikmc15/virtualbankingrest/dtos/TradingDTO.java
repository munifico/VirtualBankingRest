package com.jsikmc15.virtualbankingrest.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TradingDTO {
	 private int no;
	 private String wd_uid;
	 private String wd_print_content;
	 private String dps_uid;
	 private String dps_print_content;
	 private int tran_amt;
	 private java.sql.Date tranDate;
	 private String res_code;
	public TradingDTO() {
	}

	public void setDps_print_content(String dps_print_content) {
		this.dps_print_content = dps_print_content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWd_uid() {
		return wd_uid;
	}

	public void setWd_uid(String wd_uid) {
		this.wd_uid = wd_uid;
	}

	public String getWd_print_content() {
		return wd_print_content;
	}

	public void setWd_print_content(String wd_print_content) {
		this.wd_print_content = wd_print_content;
	}

	public String getDps_uid() {
		return dps_uid;
	}

	public void setDps_uid(String dps_uid) {
		this.dps_uid = dps_uid;
	}

	public String getDps_print_content() {
		return dps_print_content;
	}

	public int getTran_amt() {
		return tran_amt;
	}

	public void setTran_amt(int tran_amt) {
		this.tran_amt = tran_amt;
	}

	public Date getTranDate() {
		return tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public String getRes_code() {
		return res_code;
	}

	public void setRes_code(String res_code) {
		this.res_code = res_code;
	}

	@Override
	public String toString() {
		return "TradingDTO{" +
				"no=" + no +
				", wd_uid=" + wd_uid +
				", wd_print_content='" + wd_print_content + '\'' +
				", dps_uid=" + dps_uid +
				", dps_print_content=" + dps_print_content +
				", tran_amt=" + tran_amt +
				", tranDate=" + tranDate +
				", res_code='" + res_code + '\'' +
				'}';
	}
}