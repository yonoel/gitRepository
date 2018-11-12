package com.i18n_study;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * @ClassName: DateFormatTest
 * @Description: DateFormat类测试
 * @date 2018年7月5日 下午2:12:31
 * 
 */
public class DateFormatTest {
    public static void main(String[] args) {
        Date date = new Date();
        // 输出日期部分
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMANY);
        System.out.println(df.format(date));
        // 输出时间部分
        df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CHINA);
        System.out.println(df.format(date));
        // 输出日期和时间
        df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG, Locale.US);
        String result = df.format(date);
        System.out.println(result);

        // 把字符串反向解析成一个date对象
        String s = "10-9-26 下午02时49分53秒";
        df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG, Locale.CHINA);
        Date d = null;
        try {
            d = df.parse(s);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(d);

    }
}
