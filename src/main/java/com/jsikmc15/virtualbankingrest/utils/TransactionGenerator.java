package com.jsikmc15.virtualbankingrest.utils;

import com.jsikmc15.virtualbankingrest.dtos.TradingDTO;
import java.util.*;

import org.springframework.stereotype.Component;

@Component(value = "transactionGenerator")
public class TransactionGenerator {
    /*
        이전달을 기준으로 데이터를 생성한다.
        Day는 Random

        //해당 정기 데이터가 오늘에도 포함된다면 이번달 오늘것까지 만들어야함


        //비정기 데이터는 전월까지 무작위로 생성할것
     */
    public String test_fin_num ;
    public String admin_fin_num ;

    private DateGenerator dateGen;

    private static String[] unRegularContent = {"음식 구매", "사무 용품", "의류 구매","화장품 구매"};
    private static String[] regularContent = {"핸드폰비", "관리비", "보험료","신용결제","월세","청약","헬스","적금"};
    private static String[] officialContent = {"넷플릭스","왓차","웨이브","디즈니","티빙"};
    private static Integer[] officialPrices = {12000,12000,12000,12000,12000};
    
    public int getUnRegularCnt() {
    	return unRegularContent.length;
    }
    
    public int getRegularCnt() {
    	return unRegularContent.length;
    }
    
    public int getOfficialCnt() {
    	return officialContent.length;
    }
    
    public TransactionGenerator() {
        dateGen = new DateGenerator();
        test_fin_num = "sample_fintech";
        admin_fin_num = "sample_fintech";

    }

    //time : date-1 -time 달부터 ~date-1 달까지의 랜덤 비정형 데이터
    public List<TradingDTO> getExternalContent(int times, Date date,boolean isRegular,String fin_num,int regular_idx){
        List<TradingDTO> data = new ArrayList();
        Calendar myCal = Calendar.getInstance();
        myCal.setTime(date);
        List<java.sql.Date> date_list = new ArrayList();

        myCal.set(Calendar.DATE,dateGen.getRandDay(myCal.get(Calendar.MONTH)));
        String content = regularContent[regular_idx];
        for(int i = 1 ; i <= times ; i++){
            if(!isRegular)  myCal.set(Calendar.DATE,dateGen.getRandDay(myCal.get(Calendar.MONTH)));
            if(!isRegular)  content = unRegularContent[new Random().nextInt(4)];

            java.sql.Date sqlDate = new java.sql.Date(dateGen.getDateFormat(new Date(myCal.getTimeInMillis()),i*(-1),true).getTime());
            date_list.add(sqlDate);
            TradingDTO dto = new TradingDTO();
            dto.setWd_uid(fin_num);
            dto.setWd_print_content(content+" 출금");
            dto.setDps_uid(isRegular ? admin_fin_num : test_fin_num);
            dto.setDps_print_content(content+" 입금");
            dto.setTranDate(sqlDate);
            dto.setTran_amt((new Random().nextInt(300-8+1)+8)*100);
            System.out.println(dto.toString());
            data.add(dto);
        }

        return data;
    }
    
    public List<TradingDTO> getContent(int times, Date date,String fin_num,int regular_idx){
        List<TradingDTO> data = new ArrayList();
        Calendar myCal = Calendar.getInstance();
        myCal.setTime(date);
        List<java.sql.Date> date_list = new ArrayList();

        myCal.set(Calendar.DATE,dateGen.getRandDay(myCal.get(Calendar.MONTH)));
        String content = officialContent[regular_idx];
        for(int i = 1 ; i <= times ; i++){

            java.sql.Date sqlDate = new java.sql.Date(dateGen.getDateFormat(new Date(myCal.getTimeInMillis()),i*(-1),true).getTime());
            date_list.add(sqlDate);
            TradingDTO dto = new TradingDTO();
            dto.setWd_uid(fin_num);
            dto.setWd_print_content(content+" 출금");
            dto.setDps_uid(admin_fin_num );
            dto.setDps_print_content(content+" 입금");
            dto.setTranDate(sqlDate);
            dto.setTran_amt(officialPrices[regular_idx]);
            System.out.println(dto.toString());
            data.add(dto);
        }

        return data;
    }

}
