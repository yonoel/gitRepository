package com.igeek.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: Main
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月14日 上午10:05:46
 * 
 */
@Configurable
@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = { AopConfig.class })
public class Main {
    @Autowired
    private Pojo pojo;
    @Autowired
    private ProxyFactory factory;

    @Test
    public void testMethod1() {
        // pojo.bar();
        Pojo pojo = (Pojo) factory.getProxy();
        // pojo.bar();
        pojo.foo();
        throw new NullPointerException();
    }

    @Test
    public void testMethod2() {
        pojo.foo();
    }
}
