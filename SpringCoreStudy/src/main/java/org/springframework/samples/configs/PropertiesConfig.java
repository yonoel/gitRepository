package org.springframework.samples.configs;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @ClassName: PropertiesConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月4日 下午1:25:16
 * 
 */

@PropertySource("classpath:config.properties")
@Qualifier("propertiesConfig")
@Configuration
public class PropertiesConfig {
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /**  
    * @Title: toString  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @return
    * @see java.lang.Object#toString()
    */
    @Override
    public String toString() {
        return "PropertiesConfig [driver=" + driver + ", url=" + url + ", username=" + username + ", password="
                + password + "]";
    }

//    // 要想使用@Value
//    // 用${}占位符注入属性，这个bean是必须的，这个就是占位bean,另一种方式是不用value直接用Envirment变量直接getProperty('key')
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
