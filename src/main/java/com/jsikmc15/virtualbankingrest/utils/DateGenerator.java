package com.jsikmc15.virtualbankingrest.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateGenerator {

//    public static void main(String[] args) {
//        Calendar cal = Calendar.getInstance();
//
//        cal.set(2019,2,1);
//        Date test = new Date(System.currentTimeMillis());
//        System.out.println(test);
//        java.sql.Date result = new java.sql.Date(checkLastDay(test,-1).getTime());
//        System.out.println(result.toString());
//
//        for (int i = 0 ; i < 600 ; i++){
//            System.out.println(getRandDay(2));
//        }
//    }


    //특정 달의 랜덤 시작일을 결정
    public int getRandDay(int startMonth){
        Random rnd = new Random();
        Calendar myCal =  Calendar.getInstance();

        myCal.set(Calendar.MONTH,startMonth-1);
        int day = rnd.nextInt(myCal.getActualMaximum(Calendar.DAY_OF_MONTH))+1;
        myCal.set(Calendar.DATE,day);

        return day;
    }



    //정기결제 일을 구하는 메소드
    public Date getDateFormat(Date data,int before,boolean isregular){

        Calendar myCal =  Calendar.getInstance();
        myCal.setTime(data);
//        System.out.println("현재시간 : " + myCal.getTime());

        //다음달에 말일이 없으면 말일로 교환
        int current_target = myCal.get(Calendar.DATE);
        myCal.add(Calendar.MARCH,before);
        myCal.set(Calendar.DATE,myCal.getActualMaximum(Calendar.DAY_OF_MONTH));
        int next_Enday = myCal.get(Calendar.DATE);

        //다음달 말보다 안에있는 경우만 변경
        if(current_target <=next_Enday){
            myCal.set(Calendar.DATE, current_target);
        }

        //정기결제가아닌경우 날짜를 랜덤으로 반환
        if(!isregular){
            myCal.set(Calendar.DATE,getRandDay(myCal.get(Calendar.MONTH)));
        }

//        System.out.println("변환된 시간" + myCal.getTime());
        return new Date(myCal.getTimeInMillis());
    }
}

