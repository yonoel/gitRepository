package com.taglesson;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @ClassName: IFTag
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月4日 下午3:15:54
 * 
 */
public class IFTag extends SimpleTagSupport {
    private boolean flag;

    @Override
    public void doTag() throws JspException, IOException {
        if (flag) {
            this.getJspBody().invoke(null);
        }
    }

    /**
     * @return the flag
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * @param flag
     *            the flag to set
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}
