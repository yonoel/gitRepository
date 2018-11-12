package com.igeek.web.controller;

import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * @ClassName: MyObjectMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月1日 下午2:58:57
 * 
 */

public class MyObjectMapper extends ObjectMapper {

    public MyObjectMapper() {

        this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    }
}
