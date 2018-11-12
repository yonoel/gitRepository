package com.taglesson;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @ClassName: WhenTag
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月4日 下午3:28:53
 * 
 */
public class WhenTag extends SimpleTagSupport {
    /**
     * test属性，该属性值为true时，输出标签体中的内容
     */
    private boolean flag;

    @Override
    public void doTag() throws JspException, IOException {
        // 获取标签的父标签 父标签就是嵌套的上一层标签，在写页面时已经写好
        ChooseTag parentTag = (ChooseTag) this.getParent();
        if (flag == true && parentTag.isExecute() == false) {
            // 输出标签体中的内容
            this.getJspBody().invoke(null);
            // 将父标签的isExecute属性设置为true，告诉父标签，我(when标签)已经执行过了
            parentTag.setExecute(true);
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
