package com.jsikmc15.virtualbankingrest.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class OBAccountDTO {

	public String fintech_use_num;
	public String account_alias;
	public String bank_code_std;
	public String bank_code_sub;
	public String bank_name;
	public String account_num_masked;
	public String account_holder_name;
	public String account_holder_type;
	public String inquiry_agree_yn;
	public String inquiry_agree_dtime;
	public String transfer_agree_yn;
	public String transfer_agree_dtime;
	public String payer_num;
	public String savings_bank_name;
	public String account_seq;
	public String account_type;
	
	public OBAccountDTO() {
		
	}

	@Override
	public String toString() {
		return "OBAccountDTO [fintech_use_num=" + fintech_use_num + ", account_alias=" + account_alias
				+ ", bank_code_std=" + bank_code_std + ", bank_code_sub=" + bank_code_sub + ", bank_name=" + bank_name
				+ ", account_num_masked=" + account_num_masked + ", account_holder_name=" + account_holder_name
				+ ", account_holder_type=" + account_holder_type + ", inquiry_agree_yn=" + inquiry_agree_yn
				+ ", inquiry_agree_dtime=" + inquiry_agree_dtime + ", transfer_agree_yn=" + transfer_agree_yn
				+ ", transfer_agree_dtime=" + transfer_agree_dtime + ", payer_num=" + payer_num + ", savings_bank_name="
				+ savings_bank_name + ", account_seq=" + account_seq + ", account_type=" + account_type + "]";
	}
	
	

}
