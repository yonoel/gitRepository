package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
@WebFilter(initParams = {@WebInitParam(name = "charset", value = "UTF-8")})
public class CharacterEncodingFilter implements Filter {
    private FilterConfig filterConfig = null;
    // ����Ĭ�ϵ��ַ�����
    private String defaultCharset = "UTF-8";

    /**
     * Default constructor.
     */
    public CharacterEncodingFilter() {
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

        // �õ���web.xml�����õ��ַ�����
        String charset = filterConfig.getInitParameter("charset");
        if (charset == null) {
            charset = defaultCharset;
        }
        request.setCharacterEncoding(charset);
        response.setCharacterEncoding(charset);
        response.setContentType("text/html;charset=" + charset);

        MyCharacterEncodingRequest requestWrapper = new MyCharacterEncodingRequest((HttpServletRequest) request);
        // pass the request along the filter chain
        chain.doFilter(requestWrapper, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        this.filterConfig = fConfig;
    }

}

/**
 * @ClassName: MyCharacterEncodingRequest
 * @Description: Servlet
 *               API���ṩ��һ��request�����Decorator���ģʽ��Ĭ��ʵ����HttpServletRequestWrapper,
 *               (HttpServletRequestWrapper��ʵ����request�ӿ��е����з���������Щ�������ڲ�ʵ�ֶ��ǽ���������һ������װ�ĵ�
 *               request����Ķ�Ӧ����)
 *               �Ա����û��ڶ�request���������ǿʱ��Ҫʵ��request�ӿ��е����з�����
 *               ���Ե���Ҫ��ǿrequest����ʱ��ֻ��Ҫдһ����̳�HttpServletRequestWrapper�࣬Ȼ������д��Ҫ��ǿ�ķ�������
 * @author: �°�����
 * @date: 2014-9-2 ����10:42:57 1.ʵ���뱻��ǿ������ͬ�Ľӿ� 2������һ��������ס����ǿ����
 *        3������һ�����캯�������ձ���ǿ���� 4��������Ҫ��ǿ�ķ���
 *        5�����ڲ�����ǿ�ķ�����ֱ�ӵ��ñ���ǿ����Ŀ����󣩵ķ���
 */
class MyCharacterEncodingRequest extends HttpServletRequestWrapper {
    // ����һ��������ס����ǿ����(request��������Ҫ����ǿ�Ķ���)
    private HttpServletRequest request;

    // ����һ�����캯�������ձ���ǿ����
    public MyCharacterEncodingRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    /*
     * ������Ҫ��ǿ��getParameter����
     * 
     * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
     */
    @Override
    public String getParameter(String name) {
        try {
            // ��ȡ������ֵ
            String value = this.request.getParameter(name);
            if (value == null) {
                return null;
            }
            // ���������get��ʽ�ύ���ݵģ���ֱ�ӷ��ػ�ȡ����ֵ
            if (!this.request.getMethod().equalsIgnoreCase("get")) {
                return value;
            } else {
                // �������get��ʽ�ύ���ݵģ��ͶԻ�ȡ����ֵ����ת�봦��
                value = new String(value.getBytes("ISO8859-1"), this.request.getCharacterEncoding());
                return value;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
