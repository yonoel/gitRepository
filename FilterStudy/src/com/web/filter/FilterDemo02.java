package com.web.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class FilterDemo02
 */
@WebFilter(urlPatterns = { "/FilterDemo02" }, initParams = { @WebInitParam(name = "name", value = "user"),
        @WebInitParam(name = "pwd", value = "123456") })
public class FilterDemo02 implements Filter {

    /**
     * Default constructor.
     */
    public FilterDemo02() {

    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        System.out.println("----FilterDemo02 destroy----");
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("FilterDemo02 doFilter");
        chain.doFilter(request, response); // ��Ŀ����Դִ�У�����
        System.out.println("FilterDemo02 do filtet");

        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("----FilterDemo02  init----");
        // �õ�������������
        String filterName = fConfig.getFilterName();
        // �õ���web.xml�ļ������õĳ�ʼ������
        String initParam1 = fConfig.getInitParameter("name");
        String initParam2 = fConfig.getInitParameter("pwd");
        // ���ع����������г�ʼ�����������ֵ�ö�ټ��ϡ�
        Enumeration<String> initParameterNames = fConfig.getInitParameterNames();

        System.out.println(filterName);
        System.out.println(initParam1);
        System.out.println(initParam2);
        while (initParameterNames.hasMoreElements()) {
            String paramName = (String) initParameterNames.nextElement();
            System.out.println(paramName);
        }
    }

}
