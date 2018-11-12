package com.igeek.webservicesDemo;

import javax.xml.ws.Endpoint;

/**
 * @ClassName: WebServicePublish
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月31日 下午9:54:34
 * 
 */
public class WebServicePublish {
    public static void main(String[] args) {
        // 定义WebService的发布地址，这个地址就是提供给外界访问Webervice的URL地址，URL地址格式为：http://ip:端口号/xxxx
       // String address = "http://192.168.6.77:8080/";// 这个WebService发布地址的写法是合法的
        //String address ="http://192.168.6.77:8080/Webservice";//这个WebService发布地址的是合法的
        String address = "http://192.168.6.77:9000/webserviceStudy/Webservice";
        // 使用Endpoint类提供的publish方法发布WebService，发布时要保证使用的端口号没有被其他应用程序占用
        Endpoint.publish(address, new WebServicesOneImpl());
        System.out.println("发布webservice成功!");
    }
}
