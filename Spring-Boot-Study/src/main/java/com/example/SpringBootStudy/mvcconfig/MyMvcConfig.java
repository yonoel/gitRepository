package com.example.SpringBootStudy.mvcconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: MyMvcConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月11日 上午10:36:51
 * 
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer{
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
        
    }
}
