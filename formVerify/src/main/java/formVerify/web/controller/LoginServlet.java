package formVerify.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import formVerify.domain.User;
import formVerify.services.IUserServices;
import formVerify.services.impl.UserServiceImpl;
import formVerify.web.Util.RegisterFormbean;
import formVerify.web.Util.WebUtils;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取用户填写的信息
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        RegisterFormbean formBean = WebUtils.request2Bean(request, RegisterFormbean.class);
        if (formBean.validate()) {
            // 获取dao层对象
            IUserServices services = new UserServiceImpl();
            User user = services.loginUser(userName, userPwd);
            if (user != null) {
                // 登录成功后，就将用户存储到session中 session对应的就是attr了
                request.getSession().setAttribute("user", user);
                String message = String.format(
                        "恭喜：%s,登陆成功！本页将在3秒后跳到首页！！<meta http-equiv='refresh' content='3;url=%s'/>", user.getUserName(),
                        request.getContextPath() + "/index.jsp");
                request.setAttribute("message", message);

                request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
                return;
            }
        }

        String message = String.format(
                "对不起，用户名或密码有误！！请重新登录！2秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='2;url=%s'/>",
                request.getContextPath() + "/Servlet/LoginUIServlet");
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
