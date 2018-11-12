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
        // �ͻ�������UTF-8�����ύ�������ݵģ�������Ҫ���÷���������UTF-8�ı�����н��գ���������������ݾͻ��������
        request.setCharacterEncoding("UTF-8");
        String htmlStr = requesetGetParams(request);
        // ö�ٷ���
        requesetGetParamsByEnum(request);
        // Map
        requesetGetParamsBymap(request);
        response.setCharacterEncoding("UTF-8");// ���÷���������UTF-8����������ݵ��ͻ���
        response.setContentType("text/html;charset=UTF-8");// ���ÿͻ����������UTF-8�����������
        response.getWriter().write(htmlStr);// ���htmlStr��������ݵ��ͻ����������ʾ
    }

    /**
     * @Title: requesetGetParamsBymap
     * @Description: TODO(������һ�仰�����������������)
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
     * @Description: TODO(������һ�仰�����������������)
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
     * @Description: TODO(������һ�仰�����������������)
     * @param request
     * @return
     */
    private String requesetGetParams(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        // ��ȡ��д�ı�ţ�userid���ı�������֣�<input
        // type="text"
        // name="userid">
        /**
         * �û���(�ı���)��<input type="text" name="username" value="�������û���">
         */
        String username = request.getParameter("username");// ��ȡ��д���û���

        String userpass = request.getParameter("userpass");
        String sex = request.getParameter("sex");// ��ȡѡ�е��Ա�
        String dept = request.getParameter("dept");// ��ȡѡ�еĲ���
        // ��ȡѡ�е���Ȥ����Ϊ����ѡ�ж��ֵ�����Ի�ȡ����ֵ��һ���ַ������飬�����Ҫʹ��getParameterValues��������ȡ
        String[] insts = request.getParameterValues("inst");
        String note = request.getParameter("note");// ��ȡ��д��˵����Ϣ
        String hiddenField = request.getParameter("hiddenField");// ��ȡ�����������

        String instStr = "";
        /**
         * ��ȡ�������ݵļ��ɣ����Ա���insts����Ϊnullʱ�����Ŀ�ָ���쳣����
         */
        for (int i = 0; insts != null && i < insts.length; i++) {
            if (i == insts.length - 1) {
                instStr += insts[i];
            } else {
                instStr += insts[i] + ",";
            }
        }
        String htmlStr = "<table>" + "<tr><td>��д�ı�ţ�</td><td>{0}</td></tr>" + "<tr><td>��д���û�����</td><td>{1}</td></tr>"
                + "<tr><td>��д�����룺</td><td>{2}</td></tr>" + "<tr><td>ѡ�е��Ա�</td><td>{3}</td></tr>"
                + "<tr><td>ѡ�еĲ��ţ�</td><td>{4}</td></tr>" + "<tr><td>ѡ�е���Ȥ��</td><td>{5}</td></tr>"
                + "<tr><td>��д��˵����</td><td>{6}</td></tr>" + "<tr><td>����������ݣ�</td><td>{7}</td></tr>" + "</table>";
        htmlStr = MessageFormat.format(htmlStr, userid, username, userpass, sex, dept, instStr, note, hiddenField);
        return htmlStr;
    }

}