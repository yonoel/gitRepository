package com.taglesson;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @ClassName: IFTag
 * @Description: TODO(������һ�仰��������������)
 * @date 2018��7��4�� ����3:15:54
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
