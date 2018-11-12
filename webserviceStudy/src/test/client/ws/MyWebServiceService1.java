
package test.client.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MyWebServiceService1", targetNamespace = "ws.client.test", wsdlLocation = "http://192.168.6.77:9000/webserviceStudy/Webservice?wsdl")
public class MyWebServiceService1
    extends Service
{

    private final static URL MYWEBSERVICESERVICE1_WSDL_LOCATION;
    private final static WebServiceException MYWEBSERVICESERVICE1_EXCEPTION;
    private final static QName MYWEBSERVICESERVICE1_QNAME = new QName("ws.client.test", "MyWebServiceService1");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.6.77:9000/webserviceStudy/Webservice?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MYWEBSERVICESERVICE1_WSDL_LOCATION = url;
        MYWEBSERVICESERVICE1_EXCEPTION = e;
    }

    public MyWebServiceService1() {
        super(__getWsdlLocation(), MYWEBSERVICESERVICE1_QNAME);
    }

    public MyWebServiceService1(WebServiceFeature... features) {
        super(__getWsdlLocation(), MYWEBSERVICESERVICE1_QNAME, features);
    }

    public MyWebServiceService1(URL wsdlLocation) {
        super(wsdlLocation, MYWEBSERVICESERVICE1_QNAME);
    }

    public MyWebServiceService1(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MYWEBSERVICESERVICE1_QNAME, features);
    }

    public MyWebServiceService1(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MyWebServiceService1(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MyWebService1
     */
    @WebEndpoint(name = "MyWebServicePort1")
    public MyWebService1 getMyWebServicePort1() {
        return super.getPort(new QName("ws.client.test", "MyWebServicePort1"), MyWebService1.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MyWebService1
     */
    @WebEndpoint(name = "MyWebServicePort1")
    public MyWebService1 getMyWebServicePort1(WebServiceFeature... features) {
        return super.getPort(new QName("ws.client.test", "MyWebServicePort1"), MyWebService1.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MYWEBSERVICESERVICE1_EXCEPTION!= null) {
            throw MYWEBSERVICESERVICE1_EXCEPTION;
        }
        return MYWEBSERVICESERVICE1_WSDL_LOCATION;
    }

}
