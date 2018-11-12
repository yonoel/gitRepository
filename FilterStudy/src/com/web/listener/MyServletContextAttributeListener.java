package com.web.listener;

import java.text.MessageFormat;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class
 * MyServletContextAttributeListener
 *
 */
@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener {

    /**
     * Default constructor.
     */
    public MyServletContextAttributeListener() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scae) {
        String str = MessageFormat.format("ServletContext域对象中添加了属性:{0}，属性值是:{1}", scae.getName(), scae.getValue());
        System.out.println(str);
    }

    /**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        String str = MessageFormat.format("ServletContext域对象中删除属性:{0}，属性值是:{1}", scae.getName(), scae.getValue());
        System.out.println(str);
    }

    /**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        String str = MessageFormat.format("ServletContext域对象中替换了属性:{0}的值", scae.getName());
        System.out.println(str);
    }

}
