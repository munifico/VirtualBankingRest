package com.jsikmc15.virtualbankingrest.auth.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jsikmc15.virtualbankingrest.dao.TotalDAO;
import com.jsikmc15.virtualbankingrest.dtos.OBAccountDTO;
import com.jsikmc15.virtualbankingrest.dtos.OBUserDTO;
import com.jsikmc15.virtualbankingrest.utils.MyUtils;
import com.jsikmc15.virtualbankingrest.utils.ResponeCode;

@Service("authservice")
@PropertySource("classpath:prop/bank.properties")
public class AuthServiceImpl implements AuthService {

	@Value("${client.id}")
	private String clientID;
	
	@Value("${client.secret}")
	private String clientSecret;
	
	@Value("${client.callbackurl}")
	private String callbackURI;
	
	
	@Autowired
	private TotalDAO dao;
	
	@Transactional
	@Override
	public int registNew(Map map) {
		// TODO Auto-generated method stub
		
		//CI값을 가져오기위해 
		Map res = getAccountOpenBaking(map);
		
//		TestCode
//		Map res = new HashMap();
//		
//		map.put("user_ci","oFonFR22Je6DNUVfV00p66Z7dGhSWp6foI/5oOy/7wUSfx1xzM3usiAY184zmLlqjDhg4TLuYl3aHgI6/R6gHg==");
//		map.put("user_name", "첫 아이디");
//		map.put("fintech_use_num","100002200");
//		map.put("account_num_masked","23222322");
//		map.put("alias","메렁");
//		map.put("account_holder_name","나");
//		map.put("bank_name","새로운은행");
//		map.put("product_name","sample");
//		map.put("balance_amt",3403403);
//		map.put("account_type",0);
		

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		System.out.println("값:" + res.get("res_list"));
		
		OBAccountDTO accountDTO =null;
		JSONArray accounts = null;
		try {
			accounts = (JSONArray)res.get("res_list");
			accountDTO = mapper.readValue(accounts.get(0).toString(), OBAccountDTO.class);
			System.out.println(accounts);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		res.put("fintech_use_num",accountDTO.getFintech_use_num());
		res.put("account_num_masked",accountDTO.getAccount_num_masked());
		res.put("alias",accountDTO.getAccount_alias());
		res.put("account_holder_name",accountDTO.getAccount_holder_name());
		res.put("bank_name",accountDTO.getBank_name());
		res.put("product_name",accountDTO.getBank_code_std());
		res.put("balance_amt",new Random().nextInt()*(5000000-80000+1)+80000);
		res.put("account_type",0);
		map.put("user_ci", res.get("user_ci"));
		
		Set<String> keys = map.keySet();
		for(String key : keys) {
			res.put(key,map.get(key));
		}
		res.put("user_type", 0);
		//유저 토큰 등록
		res.put("user_no","");
		int affected1 = dao.insertUserToken(res);
		System.out.println("<----------------->"+affected1);
		System.out.println("<----------------->"+res.get("user_no"));
		MyUtils.sout(res);
		//유저 계좌 등록
		int affected2 = dao.insertUserAccount(res);
		
		return affected1 * affected2;
		
	}

	@Transactional
	@Override
	public int registOther(Map map) {
		// TODO Auto-generated method stub
		
		
		//CI값을 가져오기위해 
		Map res = getAccountOpenBaking(map);

//		Map res = new HashMap();
//		
//		map.put("user_ci","oFonFR22Je6DNUVfV00p66Z7dGhSWp6foI/5oOy/7wUSfx1xzM3usiAY184zmLlqjDhg4TLuYl3aHgI6/R6gHg==");
//		map.put("user_name", "첫 아이디");
//		map.put("fintech_use_num","1299902200");
//		map.put("account_num_masked","22233222322");
//		map.put("alias","메렁");
//		map.put("account_holder_name","내꺼지롱");
//		map.put("bank_name","새로운은행1");
//		map.put("product_name","sample32");
//		map.put("balance_amt",3403403);
//		map.put("account_type",0);
		
		
		
		Set<String> keys = map.keySet();
		for(String key : keys) {
			res.put(key,map.get(key));
		}
		res.put("user_type", 0);
		
//		res.put("user_no","0test");
		System.out.println("<-------------------------------->");
		MyUtils.sout(res);
		
		//유저 토큰 업데이트 
		int affected1 = dao.updateUserToken(res);
//		res.put("user_no",affected1);
		//현재 map으로 넘어온 계좌들 중에서 새로 추가된 계좌확인 후 
		//해당 user_seq로 된 유저 계좌 검색
	
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		System.out.println("값:" + res.get("res_list"));
		
		OBAccountDTO accountDTO =null;
		JSONArray accounts = null;
		try {
			accounts = (JSONArray)res.get("res_list");
			accountDTO = mapper.readValue(accounts.get(0).toString(), OBAccountDTO.class);
			System.out.println(accounts);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		res.put("fintech_use_num",accountDTO.getFintech_use_num());
		res.put("account_num_masked",accountDTO.getAccount_num_masked());
		res.put("alias",accountDTO.getAccount_alias());
		res.put("account_holder_name",accountDTO.getAccount_holder_name());
		res.put("bank_name",accountDTO.getBank_name());
		res.put("product_name",accountDTO.getBank_code_std());
		res.put("balance_amt",new Random().nextInt()*(5000000-80000+1)+80000);
		res.put("account_type",0);
		
		
		map.put("user_ci", res.get("user_ci"));
		Set<String> datas = res.keySet();
		for(String key :datas) {
			System.out.println(key+" - " +res.get(key));
		}
		//해당 계좌를 유저 계좌 추가
		int affected2 = dao.insertUserAccount(res);
		
		
		return affected1*affected2;
	}

	@Override
	public Map getAuthUrl(Map map) {
		// TODO Auto-generated method stub
		int type = 0;

		RestTemplate rt = new RestTemplate();
		HttpHeaders myheader = new HttpHeaders();
		myheader.setContentType(MediaType.APPLICATION_JSON_UTF8);
		if(map.get("USER_CI")!=null) {
			myheader.add("Kftc-Bfop-UserSeqNo", map.get("USER_SEQ_NO").toString());
			myheader.add("Kftc-Bfop-UserCI",map.get("USER_CI").toString());
			myheader.add("Kftc-Bfop-AccessToken", map.get("ACCESS_TOKEN").toString());
			type = 2;
			System.out.println("적용함");
		}
		HttpEntity<String> request = new HttpEntity("", myheader);
		String url = "https://developers.kftc.or.kr/proxy/oauth/2.0/authorize?response_type=code&client_id="+clientID+"&redirect_uri="+callbackURI+"&scope=login inquiry transfer&client_info=test&state=b80BLsfigm9OokPTjy03elbJqRHOfGSY&auth_type="+type+"&cellphone_cert_yn=Y&authorized_cert_yn=Y&account_hold_auth_yn=N&register_info=A";

		
		System.out.println("보내는 Request Entity 정보 : " + request.getHeaders());
		System.out.println("보내는 Request Entity 정보 : " + request.getBody());
		System.out.println("URL 정보 : " + url);
		ResponseEntity<Map> res = rt.exchange(url, HttpMethod.GET, request, Map.class);
		System.out.println("<-- Respone InFo -->");
		System.out.println(res.getHeaders());
		Map<String, String> result = res.getHeaders().toSingleValueMap();

		for (Map.Entry<String, String> entry : result.entrySet()) {
			System.out.println(entry.getValue() + " - " + entry.getKey());
		}
//		System.out.println("body:"+res.getBody().toString());
		map.put("location", result.get("Location"));

		return result;
		
	}

	@Override
	public Map setToken(Map map) {
		// TODO Auto-generated method stub
		
		Map<String,String> result = null;
		String code = map.get("code").toString();
		String url = "https://developers.kftc.or.kr/proxy/oauth/2.0/token";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccessControlAllowOrigin("*");
		headers.setAccessControlAllowCredentials(true);
		
		System.out.println(headers.toString());
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("code", code);
		params.add("client_id", clientID);
		params.add("client_secret", clientSecret);
		params.add("redirect_uri", callbackURI);
		params.add("grant_type", "authorization_code");

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity(params, headers);

		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> response = rt.exchange(url, 
				HttpMethod.POST, 
				entity, 
				String.class);
		
		System.out.println("<-- result -->");
		System.out.println(response.getBody());
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		try {
			result = mapper.readValue(response.getBody(), Map.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Map getAccountOpenBaking(Map map) {
		System.out.println("getAccountOB ON");
		// TODO Auto-generated method stub
		Map result = new HashMap();
		String authorization=String.format("%s %s","Bearer",map.get("access_token"));
		String url = "https://developers.kftc.or.kr/proxy/user/me?user_seq_no="+map.get("user_seq_no").toString();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", authorization);
		
		System.out.println(headers.toString());
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
//		params.add("user_seq_no", map.get("user_seq_no").toString());
		
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity(params, headers);

		System.out.println(entity.getBody());
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> response = rt.exchange(url, 
				HttpMethod.GET, 
				entity, 
				String.class);
		
//		result = response.getBody();
		System.out.println(response.getBody());
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		OBUserDTO user=null;
		try {
		
			JSONParser parse = new JSONParser();
			JSONObject json = new JSONObject((JSONObject) parse.parse(response.getBody()));
//			System.out.println("제이슨 >"+ json.toString());
//			System.out.println("제이슨 리스트>"+ json.get("res_list"));
			JSONArray arr = (JSONArray) json.get("res_list");
			json.remove("res_list");
//			System.out.println("제이슨 어레이 JSONSTRING>"+arr.toJSONString());
//			System.out.println("제이슨 어레이 STRING>"+arr.toString());
//			System.out.println("테스트 시작!");
//			for (int i = 0 ; i < arr.size();i++) {
//				System.out.println(arr.get(i).toString());
//			}
			
			user = mapper.readValue(response.getBody(), OBUserDTO.class);
			
//			System.out.println(user.toString());
			result = mapper.convertValue(user, Map.class);
			result.put("res_list", arr);
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		result.put("user_info",user);
		Set<String> keys =result.keySet();
		for(String key : keys) {
			System.out.println(key+" -- "+result.get(key));
		}
		System.out.println("getAccountOB OFF");
		return result;
		
	}

	@Override
	public boolean isUser(Map map) {
		// TODO Auto-generated method stub
		
		int affect = dao.selectConfirmUser(map);
		
		
		boolean result =(affect == 1) ? true:false;
		System.out.println("결과는 ?"+result);
		return (affect == 1) ? true:false;
	}
	
	



}
