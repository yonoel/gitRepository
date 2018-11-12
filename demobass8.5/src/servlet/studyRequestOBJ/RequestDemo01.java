package servlet.studyRequestOBJ;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo01
 */
@WebServlet("/RequestDemo01")
public class RequestDemo01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDemo01() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 1.获得客户机信息
         */
        // 通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>RequestTest</h1><hr/>");
        // 异常，这不是一个异步上下文。。。
        // AsyncContext context = request.getAsyncContext();
        // out.println("异步上下文:" + context.toString() + "<br/>");
        // 获取attr name none
        Enumeration<String> e = request.getAttributeNames();
        if (e.hasMoreElements()) {
            String attr = e.nextElement();
            Object value = request.getAttribute(attr);
            out.print("AttributeName:" + attr + ",value:" + value + "<br/>");
        } else {
            out.print("没有attr<br/>");
        }
        // null
        String authType = request.getAuthType();
        out.print("authType:" + authType + "<br/>");
        // name:JSESSIONID,value:1A39816F23F3B9026F0FB8B271E88D8E,domain:null,path:null
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                out.print("name:" + c.getName() + ",value:" + c.getValue() + ",domain:" + c.getDomain() + ",path:"
                        + c.getPath() + "<br/>");
            }
        } else {
            out.print("没有cookies<br/>");
        }
        // laocal localadd0:0:0:0:0:0:0:1
        String localAdd = request.getLocalAddr();
        out.print("localadd" + localAdd + "<br/>");
        // name:0:0:0:0:0:0:0:1,port:8080<br/>
        System.out.println("name:" + request.getLocalName() + ",port:" + request.getLocalPort() + "<br/>");

        Enumeration<Locale> locales = request.getLocales();
        // zh_CN
        if (locales.hasMoreElements()) {
            System.out.println(locales.nextElement());
        }
        // 0
        Map<String, String[]> params = request.getParameterMap();
        System.out.println(params.size());
        // remoteadd 0:0:0:0:0:0:0:1
        System.out.println(request.getRemoteAddr());
        // requestUrl /demobass8.5/RequestDemo01
        System.out.println(request.getRequestURI());
        // 获取所有的请求头
        System.out.println("==============");
        Enumeration<String> reqHeadInfos = request.getHeaderNames();
        while (reqHeadInfos.hasMoreElements()) {
            String name = reqHeadInfos.nextElement();
            String value = request.getHeader(name);
            System.out.println("headername:" + name);
            System.out.println("value:" + value);
        }
      /*  headername:host
          valuelocalhost:8080
          headername:connection
        valuekeep-alive
        headername:cache-control
        valuemax-age=0
        headername:upgrade-insecure-requests
        value1
        headername:user-agent
        valueMozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36
        headername:accept
        valuetext/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*;q=0.8
        headername:accept-encoding
        valuegzip, deflate, br
        headername:accept-language
        valuezh-CN,zh;q=0.9
        headername:cookie
        valueJSESSIONID=45754D0F89E56D3B24547E007CBC57AC*/
    
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
