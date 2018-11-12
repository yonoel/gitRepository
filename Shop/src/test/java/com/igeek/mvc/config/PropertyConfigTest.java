package com.igeek.mvc.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: PropertyConfigTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月4日 上午10:32:32
 * 
 */

public class PropertyConfigTest {

    public static void main(String[] args) {
     
       ApplicationContext context = new AnnotationConfigApplicationContext(WebAppIniinitialization
               .class);
          
       
      /* Object object = context.getEnvironment().getProperty("spring.datasource.url");
       System.out.println(object);*/
    }

}
