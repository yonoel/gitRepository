package com.web.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Servlet Filter implementation class WebResourceCachedFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, servletNames = { "ServletDemo1", "ServletDemo2" })
public class WebResourceCachedFilter implements Filter {

    /**
     * Default constructor.
     */
    public WebResourceCachedFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @Field: map ����Web��Դ��Map����
     */
    private Map<String, byte[]> map = new HashMap<String, byte[]>();

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest hrequest = (HttpServletRequest) request;
        HttpServletResponse hresponse = (HttpServletResponse) response;
        // 1.�õ��û������uri
        String uri = hrequest.getRequestURI();
        // 2.����������û��uri��Ӧ������
        byte b[] = map.get(uri);
        // 3.����������У�ֱ���û�������ݴ������������򷵻�
        if (b != null) {
            // �����ֽ������ָ�����ַ����빹���ַ���
            String webResourceHtmlStr = new String(b, response.getCharacterEncoding());
            System.out.println(webResourceHtmlStr);
            response.getOutputStream().write(b);
            return;
        }
        // 4.�������û�У���Ŀ����Դִ�У�������Ŀ����Դ�����
        BufferResponse myresponse = new BufferResponse(hresponse);
        chain.doFilter(request, myresponse);
        // ��ȡ�������е����ݵ��ֽ�����
        byte out[] = myresponse.getBuffer();
        // 5.����Դ���������û������uriΪ�ؼ��ֱ��浽������
        map.put(uri, out);
        // 6.�����ݴ�������
        response.getOutputStream().write(out);

    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

    class BufferResponse extends HttpServletResponseWrapper {
        private ByteArrayOutputStream bout = new ByteArrayOutputStream(); // ��������Ļ���
        private PrintWriter pw;
        private HttpServletResponse response;

        public BufferResponse(HttpServletResponse response) {
            super(response);
            this.response = response;
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return new MyServletOutputStream(bout);
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            pw = new PrintWriter(new OutputStreamWriter(bout, this.response.getCharacterEncoding()));
            return pw;
        }

        public byte[] getBuffer() {
            try {
                if (pw != null) {
                    pw.close();
                }
                return bout.toByteArray();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    class MyServletOutputStream extends ServletOutputStream {
        private ByteArrayOutputStream bout;

        public MyServletOutputStream(ByteArrayOutputStream bout) { // ��������д������
            this.bout = bout;
        }

        @Override
        public void write(int b) throws IOException {
            bout.write(b);
        }

        /**  
        * @Title: isReady  
        * @Description: TODO(������һ�仰�����������������)  
        * @return
        * @see javax.servlet.ServletOutputStream#isReady()
        */
        @Override
        public boolean isReady() {
            // TODO Auto-generated method stub
            return false;
        }

        /**  
        * @Title: setWriteListener  
        * @Description: TODO(������һ�仰�����������������)  
        * @param listener
        * @see javax.servlet.ServletOutputStream#setWriteListener(javax.servlet.WriteListener)
        */
        @Override
        public void setWriteListener(WriteListener listener) {
            // TODO Auto-generated method stub
            
        }
    }

}
