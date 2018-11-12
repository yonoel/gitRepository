package com.igeek.webservicesDemo;

import javax.jws.WebService;

/**
 * @ClassName: WebServicesOneImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月31日 下午9:52:46
 * 
 */
@WebService(name = "MyWebService1", serviceName = "MyWebServiceService1", portName = "MyWebServicePort1", targetNamespace = "ws.client.test")
public class WebServicesOneImpl implements WebServicesOne {

    /**
     * @Title: sayHello
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param name
     * @return
     * @see com.igeek.webservicesDemo.WebServicesOne#sayHello(java.lang.String)
     */
    @Override
    public String sayHello(String name) {
        System.out.println("name :" + name);
        return "hello " + name;
    }

    /**
     * @Title: save
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param name
     * @param password
     * @return
     * @see com.igeek.webservicesDemo.WebServicesOne#save(java.lang.String,
     *      java.lang.String)
     */
    @Override
    public String save(String name, String password) {
        System.out.println("name :" + name + ",password:" + password);
        return "save success";
    }

    /**
     * @Title: sayHello2
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param name
     * @param age
     * @return
     * @see com.igeek.webservicesDemo.WebServicesOne#sayHello2(java.lang.String,
     *      int)
     */
    @Override
    public String sayHello2(String name, int age) {
        System.out.println("name:" + name+",age:"+age);
        return name + ",你好!,年龄为:" + age;
    }

}
