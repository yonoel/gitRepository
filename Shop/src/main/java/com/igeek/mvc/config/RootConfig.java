package com.igeek.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

/**  
* @ClassName: RootConfig  
* @Description: 根配置 defines shared resources visible to all other web components
* @date 2018年8月3日 上午7:57:34    
*    
*/
@Configuration
public class RootConfig {
    // 非同源的过滤器
    @Bean
    public CsrfFilter csrfFilter() {
        return new CsrfFilter(new HttpSessionCsrfTokenRepository());
    }
    
 // Provides automatic CSRF token inclusion when using Spring MVC Form tags or Thymeleaf.
    // See http://localhost:8080/#forms and form.jsp for examples
// 自动的同源表单token验证
    @Bean
    public RequestDataValueProcessor requestDataValueProcessor() {
        return new CsrfRequestDataValueProcessor();
    }

}
