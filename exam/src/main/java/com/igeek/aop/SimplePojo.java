package com.igeek.aop;

import static java.lang.System.out;

import org.springframework.aop.framework.AopContext;

/**
 * @ClassName: SimplePojo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月14日 上午10:04:14
 * 
 */

public class SimplePojo implements Pojo {

    public void foo() {
        System.out.println("foo is called ---->");
        // this next method invocation is a direct call on the 'this' reference
        this.bar();
        System.out.println("AopContext.currentProxy()");
        ((Pojo) AopContext.currentProxy()).bar();

    }

    public void bar() {
        // some logic...
        out.println("bar is called ");
    }
    
    
}
