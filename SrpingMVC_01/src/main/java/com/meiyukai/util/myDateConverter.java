package com.meiyukai.util;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class myDateConverter implements Converter<String , Date> {

    public Date convert(String s) {
        Date date = null;
        SimpleDateFormat sdf  =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
             date = sdf.parse(s);
        }catch(Exception e){
            e.printStackTrace();
        }
        return date;
    }


}
