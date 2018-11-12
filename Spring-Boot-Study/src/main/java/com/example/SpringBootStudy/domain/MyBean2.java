package com.example.SpringBootStudy.domain;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName: MyBean
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月7日 下午2:33:50
 * 
 */
@SpringBootApplication
@ConfigurationProperties(prefix="acme")
public class MyBean2 {
    
    private String myname;

    /**
     * @return the myname
     */
    public String getMyname() {
        return myname;
    }

    /**
     * @param myname the myname to set
     */
    public void setMyname(String myname) {
        this.myname = myname;
    }

   
}
