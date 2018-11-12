package jsplesson.customtags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 * @ClassName: ViewIPTag
 * @Description: TODO(������һ�仰��������������)
 * @date 2018��7��4�� ����9:07:02
 * 
 */
public class ViewIPTag implements Tag {
    private PageContext pageContext;
    /**
     * @Title: setPageContext
     * @Description: TODO(������һ�仰�����������������)
     * @param pc
     * @see javax.servlet.jsp.tagext.Tag#setPageContext(javax.servlet.jsp.PageContext)
     */
    @Override
    public void setPageContext(PageContext pc) {
        this.pageContext = pc;
    }

    /**
     * @Title: setParent
     * @Description: TODO(������һ�仰�����������������)
     * @param t
     * @see javax.servlet.jsp.tagext.Tag#setParent(javax.servlet.jsp.tagext.Tag)
     */
    @Override
    public void setParent(Tag t) {
        // TODO Auto-generated method stub

    }

    /**
     * @Title: getParent
     * @Description: TODO(������һ�仰�����������������)
     * @return
     * @see javax.servlet.jsp.tagext.Tag#getParent()
     */
    @Override
    public Tag getParent() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @Title: doStartTag
     * @Description: TODO(������һ�仰�����������������)
     * @return
     * @throws JspException
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     */
    @Override
    public int doStartTag() throws JspException {
        // Tag�ĺ��������Process the start tag for this instance.
        System.out.println("����doStartTag()����");
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        JspWriter out = pageContext.getOut();
        String ip = request.getRemoteAddr();
        try {
            // ���������ʱ����׳�IOException�쳣
            out.write(ip);
        } catch (IOException e) {
            // ����IOException�쳣������׳�
            throw new RuntimeException(e);
        }
        return 0;
    }

    /**
     * @Title: doEndTag
     * @Description: TODO(������һ�仰�����������������)
     * @return
     * @throws JspException
     * @see javax.servlet.jsp.tagext.Tag#doEndTag()
     */
    @Override
    public int doEndTag() throws JspException {
        System.out.println("end method is called");
        return 0;
    }

    /**
     * @Title: release
     * @Description: TODO(������һ�仰�����������������)
     * @see javax.servlet.jsp.tagext.Tag#release()
     */
    @Override
    public void release() {
        System.out.println("release method is called");
    }

}
