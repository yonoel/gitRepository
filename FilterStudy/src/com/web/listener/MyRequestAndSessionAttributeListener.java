package com.web.listener;

import java.text.MessageFormat;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class
 * MyRequestAndSessionAttributeListener
 *
 */
@WebListener
public class MyRequestAndSessionAttributeListener
        implements HttpSessionAttributeListener, ServletRequestAttributeListener {

    /**
     * Default constructor.
     */
    public MyRequestAndSessionAttributeListener() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        String str = MessageFormat.format("ServletRequest域对象中删除属性:{0}，属性值是:{1}", srae.getName(), srae.getValue());
        System.out.println(str);
    }

    /**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        String str = MessageFormat.format("ServletRequest域对象中添加了属性:{0}，属性值是:{1}", srae.getName(), srae.getValue());
        System.out.println(str);
    }

    /**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        String str = MessageFormat.format("ServletRequest域对象中替换了属性:{0}的值", srae.getName());
        System.out.println(str);
    }

    /**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se) {
        String str = MessageFormat.format("HttpSession域对象中添加了属性:{0}，属性值是:{1}", se.getName(), se.getValue());
        System.out.println(str);
    }

    /**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se) {
        String str = MessageFormat.format("HttpSession域对象中删除了属性:{0}，属性值是:{1}", se.getName(), se.getValue());
        System.out.println(str);
    }

    /**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se) {
        String str = MessageFormat.format("HttpSession域对象中替换了属性:{0}，属性值是:{1}", se.getName(), se.getValue());
        System.out.println(str);
    }

}
