package formVerify.web.controller;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 移除存储在session中的user对象，实现注销功能
        request.getSession().removeAttribute("user");
        // 由于字符串中包含有单引号，在这种情况下使用MessageFormat.format方法拼接字符串时就会有问题
        // MessageFormat.format方法只是把字符串中的单引号去掉，不会将内容填充到指定的占位符中
        String message = MessageFormat.format(
                "注销成功！！3秒后为您自动跳到登录页面！！<meta http-equiv=''refresh'' content=''3;url={0}''/>",
                request.getContextPath() + "/index.jsp");
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
        
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
