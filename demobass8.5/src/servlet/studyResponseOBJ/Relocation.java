package servlet.studyResponseOBJ;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Relocation
 */
@WebServlet("/Relocation")
public class Relocation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Relocation() {
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
         * 1.����sendRedirect����ʵ�������ض���, sendRedirect�����ڲ�������
         * response.setHeader("Location", "index.jsp");
         * response.setStatus(HttpServletResponse.SC_FOUND);//����302״̬�룬��ͬ��response.setStatus(302);
         */
        response.sendRedirect("/demobass8.5/index.jsp");
        /*
         * 2.ʹ��response����302״̬�������location��Ӧͷʵ���ض���ʵ�������ض���
         * response.setHeader("Location",
         * "/JavaWeb_HttpServletResponse_Study_20140615/index.jsp");
         * response.setStatus(HttpServletResponse.SC_FOUND);//����302״̬�룬
         * ��ͬ��response.setStatus(302);
         */
        
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
