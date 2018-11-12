package formVerify.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import formVerify.domain.User;
import formVerify.services.IUserServices;
import formVerify.services.impl.UserExistException;
import formVerify.services.impl.UserServiceImpl;
import formVerify.web.Util.RegisterFormbean;
import formVerify.web.Util.WebUtils;

/**
 * Servlet implementation class RegisterServlet
 */
/**
 * @ClassName: RegisterServlet
 * @Description:用于处理用户注册的RegisterServlet
 * @date 2018年7月3日 下午12:54:37
 * 
 */
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
            // 将封装了用户填写的表单数据的formbean对象发送回register.jsp页面的form表单中进行显示
            request.setAttribute("formbean", formbean);
            // 校验失败就说明是用户填写的表单数据有问题，那么就跳转回register.jsp
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
            return;
        }
        // 校验成功
        User user = new User();
        try {
            // 注册字符串到日期的转换器
            ConvertUtils.register(new DateLocaleConverter(), java.util.Date.class);
            // 把表单的数据填充到javabean中
            // 这个方法要求属性名完全相同
            // BeanUtils一直报错date，问题解决-->在封装RegisterFormbean时，就要用DateLocaleConverter去转换
            BeanUtils.copyProperties(user, formbean);
            // 设置用户的Id属性 uuid
            user.setId(WebUtils.makeId());
            // 调用service层提供的注册用户服务实现用户注册 这里应该是dao的services
            IUserServices service = new UserServiceImpl();

            int i = service.registerUser(user);
            if (i == 1) {
                String message = String.format("注册成功！！3秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='3;url=%s'/>",
                        request.getContextPath() + "/index.jsp");
                request.setAttribute("message", message);
                request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
            }

        } catch (UserExistException e) {
            formbean.getErrors().put("userName", "注册用户已存在！！");
            request.setAttribute("formbean", formbean);
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(); // 在后台记录异常
            request.setAttribute("message", "对不起，注册失败！！");
            request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
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
