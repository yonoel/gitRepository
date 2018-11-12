package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @ClassName: FilterDemo01
 * @Description: TODO(������һ�仰��������������)
 * @date 2018��7��5�� ����3:10:27
 * 
 */
@WebFilter(urlPatterns = "/FilterDemo01")
public class FilterDemo01 implements Filter {

    /**
     * @Title: init
     * @Description: TODO(������һ�仰�����������������)
     * @param filterConfig
     * @throws ServletException
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----filter1 init----");

    }

    /**
     * @Title: doFilter
     * @Description: TODO(������һ�仰�����������������)
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // ��request��response����һЩԤ����
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("FilterDemo01 do filter");
        chain.doFilter(request, response); // ��Ŀ����Դִ�У�����
        System.out.println("FilterDemo01 do filter");

    }

    /**
     * @Title: destroy
     * @Description: TODO(������һ�仰�����������������)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        System.out.println("----filter1 destory----");
    }

}
