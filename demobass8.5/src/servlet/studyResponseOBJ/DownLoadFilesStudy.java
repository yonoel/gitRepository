package servlet.studyResponseOBJ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownLoadFilesStudy
 */
@WebServlet("/DownLoadFilesStudy")
public class DownLoadFilesStudy extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownLoadFilesStudy() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ������ҳ����ͨ��header
        // �ļ�����
        downLoadFile(response);

    }

    /**
     * @Title: downLoadFile
     * @Description: TODO(������һ�仰�����������������)
     * @param response
     */
    private void downLoadFile(HttpServletResponse response) {
        // // ��ȡinputStream,���ļ���ȡ...
        // InputStream is =
        // this.getServletContext().getResourceAsStream("2018-06-28_090541.jpg");
        // ��ȡ�ļ���
        String path = this.getServletContext().getRealPath("2018-06-28_090541.jpg");
        String name = path.substring(path.lastIndexOf("\\") + 1);
        // ����content-disposition��Ӧͷ��������������ص���ʽ���ļ�
        response.setHeader("content-disposition", "attachment;filename=" + name);
        // ��ȡ�ļ�
        InputStream is = null;
        try {
            is = new FileInputStream(path);
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        OutputStream os = null;
        byte[] barr = new byte[1024];
        int len = 0;
        try {
            os = response.getOutputStream();
            while ((len = is.read(barr)) > 0) {
                os.write(barr, 0, len);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
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
