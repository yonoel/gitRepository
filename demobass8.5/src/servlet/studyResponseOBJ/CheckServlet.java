package servlet.studyResponseOBJ;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 接收客户端浏览器提交上来的验证码
        String clientCheckcode = request.getParameter("validateCode");
        
        // 从服务器端的session中取出验证码
        String serverCheckcode = (String) request.getSession().getAttribute("checkcode");
       
        if (clientCheckcode.equals(serverCheckcode)) {// 将客户端验证码和服务器端验证比较，如果相等，则表示验证通过
            response.getOutputStream().write("验证成功".getBytes());
        } else {
            response.getOutputStream().write("验证失败".getBytes());
        }
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
