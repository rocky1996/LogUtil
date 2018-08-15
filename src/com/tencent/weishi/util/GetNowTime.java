package com.tencent.weishi.util;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetNowTime {
    public static String getTimeAccurateDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String value = sdf.format(new Date());
        return value;
    }

    public static String getTimeAccurateHour(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String value = sdf.format(new Date());
        return value;
    }

    public static Long TimeStamp(){
        return System.currentTimeMillis();
    }



    public static void main(String[] args){
//        String logName = GetNowTime.getTimeAccurateDate()+"---log.txt";
//        System.out.println(logName);
//        String str = "f://exception//";
//        try{
//            File file = new File(str,logName);
//            if(!file.exists()){
//                file.createNewFile();
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        System.out.println("888");
    }
}
