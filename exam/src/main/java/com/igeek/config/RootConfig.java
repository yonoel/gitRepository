package com.igeek.config;

/**  
* @ClassName: RootConfig  
* @Description: 根配置 defines shared resources visible to all other web components
* @date 2018年8月3日 上午7:57:34    
*    
*/

public class RootConfig {
    // 非同源的过滤器
   /* @Bean
    public CsrfFilter csrfFilter() {
        return new CsrfFilter(new HttpSessionCsrfTokenRepository());
    }*/
    
 // Provides automatic CSRF token inclusion when using Spring MVC Form tags or Thymeleaf.
    // See http://localhost:8080/#forms and form.jsp for examples
// 自动的同源表单token验证
    // @Bean
    // public RequestDataValueProcessor requestDataValueProcessor() {
    // return new CsrfRequestDataValueProcessor();
    // }

}
