package com.igeek.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @ClassName: PropertiesWithEnvironment
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月4日 上午10:45:18
 * 
 */
@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesWithEnvironment {
    @Autowired
    private Environment env;

    /**
     * @return the env
     */
    public Environment getEnv() {
        return env;
    }

    /**
     * @param env the env to set
     */
    public void setEnv(Environment env) {
        this.env = env;
    }
    
}
