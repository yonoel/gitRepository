package com.i18n_study;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * @ClassName: DateFormatTest
 * @Description: DateFormat�����
 * @date 2018��7��5�� ����2:12:31
 * 
 */
public class DateFormatTest {
    public static void main(String[] args) {
        Date date = new Date();
        // ������ڲ���
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMANY);
        System.out.println(df.format(date));
        // ���ʱ�䲿��
        df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CHINA);
        System.out.println(df.format(date));
        // ������ں�ʱ��
        df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG, Locale.US);
        String result = df.format(date);
        System.out.println(result);

        // ���ַ������������һ��date����
        String s = "10-9-26 ����02ʱ49��53��";
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
