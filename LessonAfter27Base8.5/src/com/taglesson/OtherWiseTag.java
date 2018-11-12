package com.taglesson;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @ClassName: OtherWiseTag
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月4日 下午3:31:20
 * 
 */
public class OtherWiseTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        // 获取标签的父标签
        ChooseTag parentTag = (ChooseTag) this.getParent();
        // 如果父标签下的when标签没有执行过
        if (parentTag.isExecute() == false) {
            // 输出标签体中的内容
            this.getJspBody().invoke(null);
            // 设置父标签的isExecute属性为true，告诉父标签，我(otherwise标签)已经执行过了
            parentTag.setExecute(true);
        }
    }
}
