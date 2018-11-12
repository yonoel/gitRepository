package com.web.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

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
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Servlet Filter implementation class GzipFilter
 */
@WebFilter(urlPatterns = { "*.jsp", "*.js", "*.css", "*.html" }, dispatcherTypes = { DispatcherType.FORWARD,
        DispatcherType.REQUEST })
public class GzipFilter implements Filter {

    /**
     * Default constructor.
     */
    public GzipFilter() {
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
        HttpServletResponse Hresponse = (HttpServletResponse) response;
        BufferResponse myresponse = new BufferResponse(Hresponse);
        // pass the request along the filter chain
        chain.doFilter(request, myresponse);
        // �ó������е����ݣ�ѹ�����ٴ�������
        byte out[] = myresponse.getBuffer();
        System.out.println("this original length is:" + out.length);

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        // ѹ��������е�����
        GZIPOutputStream gout = new GZIPOutputStream(bout);
        gout.write(out);
        gout.close();

        byte gzip[] = bout.toByteArray();
        System.out.println("gzip this,and the length is:" + gzip.length);

        Hresponse.setHeader("content-encoding", "gzip");
        response.setContentLength(gzip.length);
        response.getOutputStream().write(gzip);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

    class BufferResponse extends HttpServletResponseWrapper {

        /**
         * @Title: BufferResponse
         * @param response
         */
        private HttpServletResponse response;

        public BufferResponse(HttpServletResponse response) {
            super(response);
            this.response = response;
        }

        private ByteArrayOutputStream bout = new ByteArrayOutputStream();

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return new MyServletOutputStream(bout);
        }

        private PrintWriter pw;

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
                if (bout != null) {
                    bout.flush();
                    return bout.toByteArray();
                }

                return null;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    class MyServletOutputStream extends ServletOutputStream {

        private ByteArrayOutputStream bout;

        public MyServletOutputStream(ByteArrayOutputStream bout) {
            this.bout = bout;
        }

        @Override
        public void write(int b) throws IOException {
            this.bout.write(b);
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
