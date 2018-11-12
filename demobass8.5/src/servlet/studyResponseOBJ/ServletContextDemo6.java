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
         * response.setContentType("text/html;charset=UTF-8");目的是控制浏览器用UTF-8进行解码；
         * 这样就不会出现中文乱码了
         */
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>测试context对象</h1>");
        // readSrcDirPropCfgFile(response);// getResourceAsStream
        ServletContext context = this.getServletContext();
        // path /demobass8.5
        writer.println("<hr/>" + context.getContextPath() + "---->ContextPath<hr/>");
        // contextName demobass8.5 就是项目名
        writer.print(context.getServletContextName() + "----->ContextName<hr/>");
        // info Apache Tomcat/8.5.32
        writer.println(context.getServerInfo() + "---->ServerInfo<hr/>");
        // 给一个内容返回真实路径
        writer.println(context.getRealPath("db2.properties"));
        // 测试读取数据 注意路径
        writer.write("<hr/>打印数据-->");
        readSrcDirPropCfgFile(response);
        // 代码范例：使用类装载器读取资源文件
        writer.write("<hr/>类装载器读取资源文件-->");
         readPropCfgFileByLoader(response);

    }

    /**
     * @Title: readPropCfgFileByLoader
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param response
     */
    private void readPropCfgFileByLoader(HttpServletResponse response) {
        // 获取到装载当前类的类装载器
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
            response.getWriter().println("读取WebContent目录下的db2.properties配置文件：");
            response.getWriter().print(MessageFormat.format("name={0},value={1}", name, value));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * @Title: readSrcDirPropCfgFile
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param response
     */
    private void readSrcDirPropCfgFile(HttpServletResponse response) {
        // 通过context获取绝对路径
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
                response.getWriter().println("数据为空,路径有错");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        String name = prop.getProperty("name");
        String value = prop.getProperty("value");
        try {
            response.getWriter().println("读取WebContent目录下的db2.properties配置文件：");
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
