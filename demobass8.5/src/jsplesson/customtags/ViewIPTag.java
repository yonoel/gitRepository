package jsplesson.customtags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 * @ClassName: ViewIPTag
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月4日 上午9:07:02
 * 
 */
public class ViewIPTag implements Tag {
    private PageContext pageContext;
    /**
     * @Title: setPageContext
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param pc
     * @see javax.servlet.jsp.tagext.Tag#setPageContext(javax.servlet.jsp.PageContext)
     */
    @Override
    public void setPageContext(PageContext pc) {
        this.pageContext = pc;
    }

    /**
     * @Title: setParent
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param t
     * @see javax.servlet.jsp.tagext.Tag#setParent(javax.servlet.jsp.tagext.Tag)
     */
    @Override
    public void setParent(Tag t) {
        // TODO Auto-generated method stub

    }

    /**
     * @Title: getParent
     * @Description: TODO(这里用一句话描述这个方法的作用)
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
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @throws JspException
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     */
    @Override
    public int doStartTag() throws JspException {
        // Tag的核心在这里，Process the start tag for this instance.
        System.out.println("调用doStartTag()方法");
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        JspWriter out = pageContext.getOut();
        String ip = request.getRemoteAddr();
        try {
            // 这里输出的时候会抛出IOException异常
            out.write(ip);
        } catch (IOException e) {
            // 捕获IOException异常后继续抛出
            throw new RuntimeException(e);
        }
        return 0;
    }

    /**
     * @Title: doEndTag
     * @Description: TODO(这里用一句话描述这个方法的作用)
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
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @see javax.servlet.jsp.tagext.Tag#release()
     */
    @Override
    public void release() {
        System.out.println("release method is called");
    }

}
