package com.igeek.aop;

import static java.lang.System.out;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RetryAdvice
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月14日 上午10:06:47
 * 
 */
@Component
public class RetryAdvice implements MethodBeforeAdvice {

    /**
     * @Title: before
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param method
     * @param args
     * @param target
     * @throws Throwable
     * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method,
     *      java.lang.Object[], java.lang.Object)
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        out.println("method's name:" + method.getName() + ",taget class:" + target.getClass().getName()
                + ",args's length:" + args.length);
        out.println("this'is before advice");
    }

}
