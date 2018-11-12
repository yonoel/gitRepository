package com.igeek.aop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: AopConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月14日 下午1:13:59
 * 
 */
@Configuration
@ComponentScan(basePackages = "com.igeek.aop")
public class AopConfig {

    @Bean
    public SimplePojo getSimplePojo() {
        return new SimplePojo();
    }

    @Bean
    public RetryAdvice getRetryAdvice() {
        return new RetryAdvice();
    }

    @Bean
    public ProxyFactory getProxyFactory(SimplePojo simplePojo,RetryAdvice retryAdvice) {
        ProxyFactory factory = new ProxyFactory(simplePojo);
        factory.addInterface(Pojo.class);
        factory.addAdvice(retryAdvice);
        factory.setExposeProxy(true);
        return factory;
    }
}
