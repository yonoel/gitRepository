package com.taglesson;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @ClassName: RefererTag
 * @Description: TODO(������һ�仰��������������)
 * @date 2018��7��4�� ����2:34:50
 * 
 */
public class RefererTag extends SimpleTagSupport {
    // ��������
    private String site;
    // ��תҳ��
    private String page;

    @Override
    public void doTag() {
        // ���Ե��� 1.��ȡ���ʹ���������ͷ���ǲ�������web��·����ͷһ��
        JspContext context = this.getJspContext();
        // jspcontextô��getrequest��������ǿת
        PageContext pageC = (PageContext) context;
        // �����ȡ��request�ļ���Ҳ������������ǿת
        HttpServletRequest request = (HttpServletRequest) pageC.getRequest();
        String referer = request.getHeader("referer");

        if (referer == null || !referer.startsWith(site)) {
            // ��·Ϊ�ջ��߲��Ǵ��������� --->������ת
            // responseһ����������ǿת
            HttpServletResponse response = (HttpServletResponse) pageC.getResponse();
            // ��Ŀ¼
            String webRoot = request.getContextPath();
            try {
                if (page.startsWith(webRoot)) {
                    response.sendRedirect(page);
                } else {
                    response.sendRedirect(webRoot + page);
                }
                // ��ת�Ժ󣬿��Ƶ�ǰ��ҳ�治Ҫִ����ȥ��
                throw new SkipPageException("���˵�����");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SkipPageException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    /**
     * @return the site
     */
    public String getSite() {
        return site;
    }

    /**
     * @param site
     *            the site to set
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * @return the page
     */
    public String getPage() {
        return page;
    }

    /**
     * @param page
     *            the page to set
     */
    public void setPage(String page) {
        this.page = page;
    }

}
