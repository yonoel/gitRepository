package formVerify.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import formVerify.domain.User;
import formVerify.services.IUserServices;
import formVerify.services.impl.UserServiceImpl;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 根据用户名修改
        // 获取用户填写的信息
        String userName = request.getParameter("userName");
        // 获取dao层对象
        IUserServices services = new UserServiceImpl();
        // 调用查询方法
        User user = services.queryUser(userName);
        if (user == null) {
            String message = String.format("对不起，用户不存在，2秒后为您自动跳到查询页面！！<meta http-equiv='refresh' content='2;url=%s'/>",
                    request.getContextPath() + "/index.jsp");
            request.setAttribute("message", message);
            request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
            return;
        }
        // 存在删除
        int i = services.delete(user);
        if (i == 0) {
            String message = String.format("对不起，用户删除失败，2秒后为您自动跳到查询页面！！<meta http-equiv='refresh' content='2;url=%s'/>",
                    request.getContextPath() + "/index.jsp");
            request.setAttribute("message", message);
            request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
            return;
        }
        String message = String.format("用户删除成功，2秒后为您自动跳到查询页面！！<meta http-equiv='refresh' content='2;url=%s'",
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
