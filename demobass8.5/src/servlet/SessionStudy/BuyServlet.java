package servlet.SessionStudy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ���������������ݵ�����
        String id = request.getParameter("id");
        // �õ��û��������
        Book book = DB.getAll().get(id);
        HttpSession session = request.getSession();

        // get list from session 1.have 2.no
        // �õ��û����ڱ��������������

        @SuppressWarnings("unchecked")
        List<Book> list = (List<Book>) session.getAttribute("list");
        if (list == null) {
            list = new ArrayList<Book>();
        }
        // ��д�˲���ֵ
        list.add(book);
        session.setAttribute("list", list);
        
        // ��д��ַ��֮ǰsessionЯ����idֵ������
        String url = response.encodeRedirectURL(request.getContextPath() + "/ListCartServlet");

        // ����ֱ�Ӵ���ת�ӵ�Listcart
        response.sendRedirect(url);

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
