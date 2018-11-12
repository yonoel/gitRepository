package com.igeek.webservicesDemo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.xml.ws.Endpoint;

/**
 * Application Lifecycle Listener implementation class WebServicePublishListener
 *
 */
@WebListener
public class WebServicePublishListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public WebServicePublishListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        //WebService的发布地址
        String address = "http://192.168.6.77:9001/webserviceStudy/WebService";
        //发布WebService，WebServiceImpl类是WebServie接口的具体实现类
        Endpoint.publish(address , new WebServicesOneImpl());
        System.out.println("使用WebServicePublishListener发布webservice成功!");
    }
	
}
