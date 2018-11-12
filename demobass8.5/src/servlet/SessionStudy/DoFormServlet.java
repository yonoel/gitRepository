package servlet.SessionStudy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoFormServlet
 */
@WebServlet("/DoFormServlet")
public class DoFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean b = isRepeatSubmit(request);// �ж��û��Ƿ����ظ��ύ
        if (b == true) {
            System.out.println("you have repeat");
            return;
        }
        request.getSession().removeAttribute("token");// �Ƴ�session�е�token
    }

    /**
     * @Title: isRepeatSubmit
     * @Description: �жϿͻ����ύ���������ƺͷ����������ɵ������Ƿ�һ��
     * @param request
     * @return
     */
    private boolean isRepeatSubmit(HttpServletRequest request) {
        String client_token = request.getParameter("token");
        // 1������û��ύ�ı�������û��token�����û����ظ��ύ�˱�
        if (client_token == null) {
            return true;
        }
        // ȡ���洢��Session�е�token
        String server_token = (String) request.getSession().getAttribute("token");
        // 2�������ǰ�û���Session�в�����Token(����)�����û����ظ��ύ�˱�
        if (server_token == null) {
            return true;
        }
        // 3���洢��Session�е�Token(����)����ύ��Token(����)��ͬ�����û����ظ��ύ�˱�
        if (!client_token.equals(server_token)) {
            return true;
        }

        return false;
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
