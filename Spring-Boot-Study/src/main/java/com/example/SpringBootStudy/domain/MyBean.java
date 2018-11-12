package com.example.SpringBootStudy.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: MyBean
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月7日 下午2:33:50
 * 
 */
@SpringBootApplication
@ComponentScan
public class MyBean {
    @Value("${name}")
    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
