package servlet.SessionStudy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: SessionDemo01
 * @Description: TODO(������һ�仰��������������)
 * @date 2018��6��29�� ����10:18:47
 * 
 */
@WebServlet(urlPatterns = "/SessionDemo01")
public class SessionDemo01 extends HttpServlet {

    /**
     * @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("content-type", "text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        // get session
        HttpSession session = request.getSession();
        // session.setAttribute("data", "igeek");

        // ��ʹû��set��������attr ��Ϊsession�Ĵ��������һ��������Ŀ�����ر�

        Enumeration<String> attrbutes = session.getAttributeNames();
        while (attrbutes.hasMoreElements()) {
            writer.println("attrbute's name:" + attrbutes.nextElement());
        }
        writer.println("seesion ");
        // String id = session.getId();
        // if (session.isNew()) {
        // response.getWriter().print("session is new " +
        // session.getAttribute("data"));
        // } else {
        // response.getWriter().println("session is old " +
        // session.getCreationTime());
        // }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
