package com.igeek.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @ClassName: CharacterEncodingFilter
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月30日 上午9:46:24
 * 
 */
@WebFilter(urlPatterns="/*",initParams=@WebInitParam(name="encoding",value="UTF-8"))
public class CharacterEncodingFilter implements Filter {
    private String encode = null;

    /**
     * @Title: init
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param filterConfig
     * @throws ServletException
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("CharacterEncodingFilter.init()...............");
        encode = filterConfig.getInitParameter("encoding");

    }

    /**
     * @Title: doFilter
     * @Description: TODO(这里用一句话描述这个方法的作用)
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
        // TODO Auto-generated method stub
        // System.out.println("CharacterEncodingFilter.doFilter()...............");

        // HttpServletRequest request2 = (HttpServletRequest) request;
        // System.out.println(request.getRequestURL()+"?"+request.getQueryString());
        // 设置请求对象编码方式
        request.setCharacterEncoding(encode);
        // 设置响应对象编码方式
        response.setContentType("text/html;charset=" + encode);

        // 释放后续资源
        chain.doFilter(request, response);

    }

    /**
     * @Title: destroy
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("CharacterEncodingFilter.destroy()...............");
        encode = null;

    }

}
