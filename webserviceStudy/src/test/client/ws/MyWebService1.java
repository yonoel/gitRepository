
package test.client.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MyWebService1", targetNamespace = "ws.client.test")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MyWebService1 {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "save", targetNamespace = "ws.client.test", className = "test.client.ws.Save")
    @ResponseWrapper(localName = "saveResponse", targetNamespace = "ws.client.test", className = "test.client.ws.SaveResponse")
    @Action(input = "ws.client.test/MyWebService1/saveRequest", output = "ws.client.test/MyWebService1/saveResponse")
    public String save(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "ws.client.test", className = "test.client.ws.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "ws.client.test", className = "test.client.ws.SayHelloResponse")
    @Action(input = "ws.client.test/MyWebService1/sayHelloRequest", output = "ws.client.test/MyWebService1/sayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello2", targetNamespace = "ws.client.test", className = "test.client.ws.SayHello2")
    @ResponseWrapper(localName = "sayHello2Response", targetNamespace = "ws.client.test", className = "test.client.ws.SayHello2Response")
    @Action(input = "ws.client.test/MyWebService1/sayHello2Request", output = "ws.client.test/MyWebService1/sayHello2Response")
    public String sayHello2(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

}
