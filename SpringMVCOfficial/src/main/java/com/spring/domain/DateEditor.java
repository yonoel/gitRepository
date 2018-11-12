package com.spring.domain;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DateEditor
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月12日 下午8:43:02
 * 
 */
public class DateEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Date date = null;
        // String text ---->value
        try {
            if (text.contains("-")) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(text);
            } else {
                date = new SimpleDateFormat("yyyy/MM/dd").parse(text);
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.setValue(date);
    }

}
