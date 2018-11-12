package com.igeek.webservicesDemo;

import test.client.ws.MyWebService1;
import test.client.ws.MyWebServiceService1;

/**  
* @ClassName: WSClient  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月1日 上午9:07:22    
*    
*/
public class WSClient {
    public static void main(String[] args) {
        //创建一个用于产生WebService1实例的工厂，WebServicService1类是wsimport工具生成的
        MyWebServiceService1 myWebServiceService1 = new MyWebServiceService1();
        MyWebService1 myWebService1 =myWebServiceService1.getMyWebServicePort1();
        
        String resultString = myWebService1.sayHello("站撒");
        System.out.println(resultString);
    }
}
