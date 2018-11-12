package servlet.SessionStudy;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FormServlet
 */
// ��������Token(����)����ת��form.jspҳ��
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // FormServlet ��������Token(����)����ת��form.jspҳ��
        String token = TokenProccessor.getInstance().makeToken();// ��������
        request.getSession().setAttribute("token", token); // �ڷ�����ʹ��session����token(����)
        request.getRequestDispatcher("/form.jsp").forward(request, response);// ��ת��form.jspҳ��
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

class TokenProccessor {

    /*
     * �������ģʽ����֤��Ķ������ڴ���ֻ��һ���� 1������Ĺ��캯��˽�� 2���Լ�����һ����Ķ��� 3�������ṩһ�������ķ�����������Ķ���
     */
    private TokenProccessor() {
    }

    private static final TokenProccessor instance = new TokenProccessor();

    /**
     * ������Ķ���
     * 
     * @return
     */
    public static TokenProccessor getInstance() {
        return instance;
    }

    /**
     * ����Token Token��Nv6RRuGEVvmGjB+jimI/gw==
     * 
     * @return
     */
    public String makeToken() { // checkException
        // 7346734837483 834u938493493849384 43434384
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        // ����ָ�� 128λ�� 16���ֽ� md5
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(token.getBytes());
            // base64����--��������Ʊ��������ַ� adfsdfsdfsf
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
