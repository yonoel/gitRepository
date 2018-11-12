package formVerify.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;

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
import formVerify.web.Util.WebUtils;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 将客户端提交的表单数据封装到RegisterFormBean对象中
        // 其实这里封装了两个方法，一个是BeanUtils封装一个bean给RegisterFormbean，这个bean的数据比UserBean要多,可以考虑继承
        RegisterFormbean formbean = WebUtils.request2Bean(request, RegisterFormbean.class);
        // 校验用户注册填写的表单数据
        if (formbean.validate() == false) {
            // 如果校验失败
            // 将封装了用户填写的表单数据的formbean对象发送回index.jsp页面的form表单中进行显示
            request.setAttribute("formbean", formbean);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        // 校验成功 ，获取session里的UserID
        User user = (User) request.getSession().getAttribute("user");
        // 注册字符串到日期的转换器
        ConvertUtils.register(new DateLocaleConverter(), java.util.Date.class);
        try {
            BeanUtils.copyProperties(user, formbean);
            // 调用dao更新数据
            // 获取dao层对象
            IUserServices services = new UserServiceImpl();
            int i = services.update(user);
            // 只有等于1 说明更新成功
            if (i == 1) {
                // 更新存储在session中的user对象
                request.getSession().removeAttribute("user");
                request.getSession().setAttribute("user", user);
                String message = MessageFormat.format(
                        "更新成功！！3秒后为您自动跳到登录页面！！<meta http-equiv=''refresh'' content=''3;url={0}''/>",
                        request.getContextPath() + "/index.jsp");
                request.setAttribute("message", message);
                request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
                return;
            }
            String message = MessageFormat.format(
                    "更新失败！！3秒后为您自动跳到登录页面！！<meta http-equiv=''refresh'' content=''3;url={0}''/>",
                    request.getContextPath() + "/index.jsp");
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
