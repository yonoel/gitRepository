package formVerify.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import formVerify.domain.User;
import formVerify.services.IUserServices;
import formVerify.services.impl.UserServiceImpl;
import formVerify.web.Util.RegisterFormbean;

/**
 * Servlet implementation class QueryServlet
 */
public class QueryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 查询方法 1.其实和注册差不多，取提交的元素值，然后打包成一个bean，2.找services层匹配,3返回结果，安排不同的视图
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
        // user如果存在 给一个页面展示。。
        String message = "查询成功";
        // 注册字符串到日期的转换器
        ConvertUtils.register(new DateLocaleConverter(), java.util.Date.class);
        RegisterFormbean formbean = new RegisterFormbean();
        try {
            BeanUtils.copyProperties(formbean, user);
            request.setAttribute("formbean", formbean);
            request.setAttribute("message", message);
            request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
