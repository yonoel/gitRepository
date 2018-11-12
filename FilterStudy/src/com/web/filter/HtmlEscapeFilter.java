package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class HtmlEscapeFilter
 */
@WebFilter("/HtmlEscapeFilter")
public class HtmlEscapeFilter implements Filter {

    /**
     * Default constructor.
     */
    public HtmlEscapeFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest hrequest = (HttpServletRequest) request;

        MyHtmlRequest myrequest = new MyHtmlRequest(hrequest);

        // pass the request along the filter chain
        chain.doFilter(myrequest, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}

/**
 * @ClassName: MyHtmlRequest
 * @Description: 使用Decorator模式包装request对象，实现html标签转义功能
 * @author: 孤傲苍狼
 * @date: 2014-9-2 下午11:29:09
 *
 */
class MyHtmlRequest extends HttpServletRequestWrapper {

    private HttpServletRequest request;

    public MyHtmlRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    /*
     * 覆盖需要增强的getParameter方法
     * 
     * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
     */
    @Override
    public String getParameter(String name) {
        String value = this.request.getParameter(name);
        if (value == null) {
            return null;
        }
        // 调用filter转义value中的html标签
        return filter(value);
    }

    /**
     * @Method: filter
     * @Description: 过滤内容中的html标签
     * @Anthor:孤傲苍狼
     * @param message
     * @return
     */
    public String filter(String message) {
        if (message == null) {
            return null;
        }
        char content[] = new char[message.length()];
        message.getChars(0, message.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
            case '<':
                result.append("&lt;");
                break;
            case '>':
                result.append("&gt;");
                break;
            case '&':
                result.append("&amp;");
                break;
            case '"':
                result.append("&quot;");
                break;
            default:
                result.append(content[i]);
            }
        }
        return result.toString();
    }
}