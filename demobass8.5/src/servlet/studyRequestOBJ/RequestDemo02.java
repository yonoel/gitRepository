package servlet.studyRequestOBJ;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo02
 */
@WebServlet("/RequestDemo02")
public class RequestDemo02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDemo02() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 客户端是以UTF-8编码提交表单数据的，所以需要设置服务器端以UTF-8的编码进行接收，否则对于中文数据就会产生乱码
        request.setCharacterEncoding("UTF-8");
        String htmlStr = requesetGetParams(request);
        // 枚举方法
        requesetGetParamsByEnum(request);
        // Map
        requesetGetParamsBymap(request);
        response.setCharacterEncoding("UTF-8");// 设置服务器端以UTF-8编码输出数据到客户端
        response.setContentType("text/html;charset=UTF-8");// 设置客户端浏览器以UTF-8编码解析数据
        response.getWriter().write(htmlStr);// 输出htmlStr里面的内容到客户端浏览器显示
    }

    /**
     * @Title: requesetGetParamsBymap
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param request
     */
    private void requesetGetParamsBymap(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        map.entrySet().forEach(p -> {
            if (p.getValue().length > 1) {

                System.out.println(p.getKey() + "=" + Arrays.asList(p.getValue()));
            } else {
                System.out.println(p.getKey() + "=" + p.getValue()[0]);
            }

        });

    }

    /**
     * @Title: requesetGetParamsByEnum
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param request
     * @return
     */
    private void requesetGetParamsByEnum(HttpServletRequest request) {
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String[] value = request.getParameterValues(name);
            if (value.length <= 1) {
                System.out.println(MessageFormat.format("{0}={1}", name, value[0]));
            } else {
                System.out.print(name + "=");
                for (String string : value) {
                    System.out.print(string + ",");
                }
                System.out.println();
            }

        }
    }

    /**
     * @Title: requesetGetParams
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param request
     * @return
     */
    private String requesetGetParams(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        // 获取填写的编号，userid是文本框的名字，<input
        // type="text"
        // name="userid">
        /**
         * 用户名(文本框)：<input type="text" name="username" value="请输入用户名">
         */
        String username = request.getParameter("username");// 获取填写的用户名

        String userpass = request.getParameter("userpass");
        String sex = request.getParameter("sex");// 获取选中的性别
        String dept = request.getParameter("dept");// 获取选中的部门
        // 获取选中的兴趣，因为可以选中多个值，所以获取到的值是一个字符串数组，因此需要使用getParameterValues方法来获取
        String[] insts = request.getParameterValues("inst");
        String note = request.getParameter("note");// 获取填写的说明信息
        String hiddenField = request.getParameter("hiddenField");// 获取隐藏域的内容

        String instStr = "";
        /**
         * 获取数组数据的技巧，可以避免insts数组为null时引发的空指针异常错误！
         */
        for (int i = 0; insts != null && i < insts.length; i++) {
            if (i == insts.length - 1) {
                instStr += insts[i];
            } else {
                instStr += insts[i] + ",";
            }
        }
        String htmlStr = "<table>" + "<tr><td>填写的编号：</td><td>{0}</td></tr>" + "<tr><td>填写的用户名：</td><td>{1}</td></tr>"
                + "<tr><td>填写的密码：</td><td>{2}</td></tr>" + "<tr><td>选中的性别：</td><td>{3}</td></tr>"
                + "<tr><td>选中的部门：</td><td>{4}</td></tr>" + "<tr><td>选中的兴趣：</td><td>{5}</td></tr>"
                + "<tr><td>填写的说明：</td><td>{6}</td></tr>" + "<tr><td>隐藏域的内容：</td><td>{7}</td></tr>" + "</table>";
        htmlStr = MessageFormat.format(htmlStr, userid, username, userpass, sex, dept, instStr, note, hiddenField);
        return htmlStr;
    }

}
