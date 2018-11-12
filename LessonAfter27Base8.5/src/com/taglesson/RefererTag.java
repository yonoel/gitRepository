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
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月4日 下午2:34:50
 * 
 */
public class RefererTag extends SimpleTagSupport {
    // 网络域名
    private String site;
    // 跳转页面
    private String page;

    @Override
    public void doTag() {
        // 测试盗链 1.获取访问过来的请求头，是不是与我web的路径开头一样
        JspContext context = this.getJspContext();
        // jspcontext么有getrequest方法。。强转
        PageContext pageC = (PageContext) context;
        // 这个获取的request的级别也不够。。继续强转
        HttpServletRequest request = (HttpServletRequest) pageC.getRequest();
        String referer = request.getHeader("referer");

        if (referer == null || !referer.startsWith(site)) {
            // 来路为空或者不是从域名来的 --->让它跳转
            // response一样不给力，强转
            HttpServletResponse response = (HttpServletResponse) pageC.getResponse();
            // 根目录
            String webRoot = request.getContextPath();
            try {
                if (page.startsWith(webRoot)) {
                    response.sendRedirect(page);
                } else {
                    response.sendRedirect(webRoot + page);
                }
                // 跳转以后，控制当前的页面不要执行下去了
                throw new SkipPageException("有人盗链啊");
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
