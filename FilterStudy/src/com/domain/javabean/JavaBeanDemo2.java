package com.domain.javabean;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * @ClassName: JavaBeanDemo2
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月6日 上午10:31:35
 * 
 */
public class JavaBeanDemo2 implements HttpSessionActivationListener, Serializable {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 5751771783435122720L;

    /**
     * @Title: sessionWillPassivate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param se
     * @see javax.servlet.http.HttpSessionActivationListener#sessionWillPassivate(javax.servlet.http.HttpSessionEvent)
     */
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("this " + this.name + " will passivate and seesion id :" + se.getSession().getId());
    }

    private String name;

    /**
     * @Title: JavaBeanDemo2
     */
    public JavaBeanDemo2() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @Title: JavaBeanDemo2
     * @param name
     */
    public JavaBeanDemo2(String name) {
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
     * @Title: sessionDidActivate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param se
     * @see javax.servlet.http.HttpSessionActivationListener#sessionDidActivate(javax.servlet.http.HttpSessionEvent)
     */
    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("this " + this.name + "will didactivate and seession id is:" + se.getSession().getId());
    }

}
