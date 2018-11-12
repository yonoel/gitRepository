package com.web.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
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
 * Servlet Filter implementation class DirtyFilter
 */
@WebFilter(urlPatterns = { "/DirtyFilter" }, initParams = {
        @WebInitParam(name = "dirtyWord", value = "/WEB-INF/DirtyWord.txt") })
public class DirtyFilter implements Filter {
    private FilterConfig config = null;

    /**
     * Default constructor.
     */
    public DirtyFilter() {
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
        DirtyRequest dirtyrequest = new DirtyRequest(hrequest);
        // pass the request along the filter chain
        chain.doFilter(dirtyrequest, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        this.config = fConfig;
    }

    /**
     * @Method: getDirtyWords
     * @Description: ��ȡ�����ַ�
     * @Anthor:�°�����
     *
     * @return
     */
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
        // InputStreamReader is = null;
        // try { // ��utf-8������
        // is = new InputStreamReader(inputStream, "UTF-8");
        // } catch (UnsupportedEncodingException e2) {
        // e2.printStackTrace();
        // }
        // // ��������ȡ
        // BufferedReader reader = new BufferedReader(is);
        // String line;
        // try {
        // while ((line = reader.readLine()) != null) {
        // // ��� lineΪ��˵�������ˣ�����list
        // dirtyWords.add(line);
        // }
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

    }

    class DirtyRequest extends HttpServletRequestWrapper {

        private List<String> dirtyWords = getDirtyWords();
        private HttpServletRequest request;

        //
        public DirtyRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        /*
         * ��дgetParameter������ʵ�ֶ������ַ��Ĺ���
         * 
         * @see
         * javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
         */
        @Override
        public String getParameter(String name) {

            String value = this.request.getParameter(name);
            if (value == null) {
                return null;
            }

            for (String dirtyWord : dirtyWords) {
                if (value.contains(dirtyWord)) {
                    System.out.println("�����а������дʣ�" + dirtyWord + "�����ᱻ�滻��****");
                    // �滻�����ַ�
                    value = value.replace(dirtyWord, "****");
                }
            }
            return value;
        }
    }
}
