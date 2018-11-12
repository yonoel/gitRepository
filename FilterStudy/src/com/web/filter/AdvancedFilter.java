package com.web.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet Filter implementation class AdvancedFilter
 */
@WebFilter(urlPatterns = { "/*" }, initParams = { @WebInitParam(name = "dirtyWord", value = "/WEB-INF/DirtyWord.txt"),
        @WebInitParam(name = "charset", value = "UTF-8") })
public class AdvancedFilter implements Filter {

    private String defaultCharset = "UTF-8";

    /**
     * Default constructor.
     */
    public AdvancedFilter() {
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
        String charset = config.getInitParameter("charset");
        if (charset == null) {
            charset = defaultCharset;
        }
        request.setCharacterEncoding(charset);
        response.setCharacterEncoding(charset);
        response.setContentType("text/html;charset=" + charset);
        AdvancedRequest requestWrapper = new AdvancedRequest(hrequest);
        // pass the request along the filter chain
        chain.doFilter(requestWrapper, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        this.config = fConfig;
    }

    private FilterConfig config;

    class AdvancedRequest extends HttpServletRequestWrapper {
        private HttpServletRequest request;
        private List<String> dirtyWords = getDirtyWords();

        /**
         * @Title: AdvancedRequest
         * @param request
         */
        public AdvancedRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        // ��дgetParameter����
        @Override
        public String getParameter(String name) {
            // ��ȡ������ֵ
            String value = this.request.getParameter(name);
            if (value == null) {
                return null;
            }
            // ���������get��ʽ�ύ���ݵģ���ֱ�ӷ��ػ�ȡ����ֵ
            if (!this.request.getMethod().equalsIgnoreCase("get")) {
                // ����filterת��value�е�html��ǩ
                value = filter(value);
            } else {
                // �������get��ʽ�ύ���ݵģ��ͶԻ�ȡ����ֵ����ת�봦��
                try {
                    value = new String(value.getBytes("ISO8859-1"), this.request.getCharacterEncoding());
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // ����filterת��value�е�html��ǩ
                value = filter(value);
            }
            // dirtyWord����
            for (String string : dirtyWords) {
                if (value.contains(string)) {
                    value.replaceAll(string, "****");
                }
            }
            return value;
        }

        /**
         * @Title: filter
         * @Description: ���������е�html��ǩ��get����ֱ���ύ��post����ת��UTF-8����
         * @param value
         * @return
         */
        private String filter(String value) {
            if (value == null) {
                return null;
            }
            char content[] = new char[value.length()];
            value.getChars(0, value.length(), content, 0);
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

    // ��ȡĬ��dirtyWord �ķ���
    private List<String> getDirtyWords() {
        List<String> dirtyWords = new ArrayList<String>();
        // ��ȡֵ����ȡ�����ļ�
        String dirtyWordPath = config.getInitParameter("dirtyWord");
        // ��Ĭ�ϱ����ȡ��
        InputStream inputStream = config.getServletContext().getResourceAsStream(dirtyWordPath);
        BufferedReader br = null;
        try {

            br = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
            String line = null;
            while ((line = br.readLine()) != null) {
                dirtyWords.add(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dirtyWords;
    }
}
