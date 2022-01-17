package com.jsikmc15.virtualbankingrest.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class OBUserDTO {

	@JsonProperty("api_tran_id")
	public String api_tran_id;
	@JsonProperty("rep_code")
	public String rsp_code;
	public String rsp_message;
	public String api_tran_dtm;
	public String user_seq_no;
	public String user_ci;
	public String user_name;
	public String res_cnt;
	public List<OBAccountDTO> res_list = null;
	public String inquiry_card_cnt;
	public List<Object> inquiry_card_list = null;
	public String inquiry_pay_cnt;
	public List<Object> inquiry_pay_list = null;
	
	public OBUserDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OBUserDTO [api_tran_id=" + api_tran_id + ", rsp_code=" + rsp_code + ", rsp_message=" + rsp_message
				+ ", api_tran_dtm=" + api_tran_dtm + ", user_seq_no=" + user_seq_no + ", user_ci=" + user_ci
				+ ", user_name=" + user_name + ", res_cnt=" + res_cnt + ", res_list=" + res_list + ", inquiry_card_cnt="
				+ inquiry_card_cnt + ", inquiry_card_list=" + inquiry_card_list + ", inquiry_pay_cnt=" + inquiry_pay_cnt
				+ ", inquiry_pay_list=" + inquiry_pay_list + "]";
	}
	
	
	
}
