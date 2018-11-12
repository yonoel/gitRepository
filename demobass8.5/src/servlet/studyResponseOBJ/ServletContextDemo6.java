package servlet.studyResponseOBJ;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextDemo6
 */
@WebServlet("/ServletContextDemo6")
public class ServletContextDemo6 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContextDemo6() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * response.setContentType("text/html;charset=UTF-8");Ŀ���ǿ����������UTF-8���н��룻
         * �����Ͳ����������������
         */
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>����context����</h1>");
        // readSrcDirPropCfgFile(response);// getResourceAsStream
        ServletContext context = this.getServletContext();
        // path /demobass8.5
        writer.println("<hr/>" + context.getContextPath() + "---->ContextPath<hr/>");
        // contextName demobass8.5 ������Ŀ��
        writer.print(context.getServletContextName() + "----->ContextName<hr/>");
        // info Apache Tomcat/8.5.32
        writer.println(context.getServerInfo() + "---->ServerInfo<hr/>");
        // ��һ�����ݷ�����ʵ·��
        writer.println(context.getRealPath("db2.properties"));
        // ���Զ�ȡ���� ע��·��
        writer.write("<hr/>��ӡ����-->");
        readSrcDirPropCfgFile(response);
        // ���뷶����ʹ����װ������ȡ��Դ�ļ�
        writer.write("<hr/>��װ������ȡ��Դ�ļ�-->");
         readPropCfgFileByLoader(response);

    }

    /**
     * @Title: readPropCfgFileByLoader
     * @Description: TODO(������һ�仰�����������������)
     * @param response
     */
    private void readPropCfgFileByLoader(HttpServletResponse response) {
        // ��ȡ��װ�ص�ǰ�����װ����
        ClassLoader loader = ServletContextDemo6.class.getClassLoader();
        InputStream in = loader.getResourceAsStream("db2.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String name = prop.getProperty("name");
        String value = prop.getProperty("value");
        try {
            response.getWriter().println("��ȡWebContentĿ¼�µ�db2.properties�����ļ���");
            response.getWriter().print(MessageFormat.format("name={0},value={1}", name, value));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * @Title: readSrcDirPropCfgFile
     * @Description: TODO(������һ�仰�����������������)
     * @param response
     */
    private void readSrcDirPropCfgFile(HttpServletResponse response) {
        // ͨ��context��ȡ����·��
        InputStream path = this.getServletContext().getResourceAsStream("/WEB-INF/db2.properties");

        Properties prop = new Properties();
        try {

            prop.load(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (prop.isEmpty()) {
            try {
                response.getWriter().println("����Ϊ��,·���д�");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        String name = prop.getProperty("name");
        String value = prop.getProperty("value");
        try {
            response.getWriter().println("��ȡWebContentĿ¼�µ�db2.properties�����ļ���");
            response.getWriter().print(MessageFormat.format("name={0},value={1}", name, value));
        } catch (IOException e) {
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
