package com.igeek.webservicesDemo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @ClassName: WebServicesOne
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月31日 下午9:49:07
 * 
 */
@WebService
public interface WebServicesOne {
    @WebMethod(exclude=true)
    String sayHello(String name);
    
    @WebMethod(operationName="sayHello")
    @WebResult(name="result")String sayHello2(@WebParam(name="name") String name,@WebParam(name="age") int age);

    @WebMethod
    String save(String name, String password);
}
