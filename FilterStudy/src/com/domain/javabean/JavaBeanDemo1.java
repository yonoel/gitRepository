package com.domain.javabean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @ClassName: JavaBeanDemo1
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月6日 上午10:23:19
 * 
 */
public class JavaBeanDemo1 implements HttpSessionBindingListener {
    private String name;

    /**
     * @Title: JavaBeanDemo1
     */
    public JavaBeanDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @Title: JavaBeanDemo1
     * @param name
     */
    public JavaBeanDemo1(String name) {
        super();
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @Title: valueBound
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param event
     * @see javax.servlet.http.HttpSessionBindingListener#valueBound(javax.servlet.http.HttpSessionBindingEvent)
     */
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("this object " + this.name + " is binded to session");
    }

    /**
     * @Title: valueUnbound
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param event
     * @see javax.servlet.http.HttpSessionBindingListener#valueUnbound(javax.servlet.http.HttpSessionBindingEvent)
     */
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("this object " + this.name + " is unbound");
    }

}
