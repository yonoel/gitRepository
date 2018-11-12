package com.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @ClassName: DateConvert
 * @Description: 这个convert什么类型都能转
 * @date 2018年7月12日 下午8:54:03
 * 
 */

public class DateConvert implements Converter<String, Date> {

    /**
     * @Title: convert
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param source
     * @return
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public Date convert(String source) {
        Date date = null;
        // String text ---->value
        try {
            if (source.contains("-")) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(source);
            } else {
                date = new SimpleDateFormat("yyyy/MM/dd").parse(source);
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

}
