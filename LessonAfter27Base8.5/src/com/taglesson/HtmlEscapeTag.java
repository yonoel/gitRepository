package com.taglesson;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @ClassName: HtmlEscapeTag
 * @Description: html转义标签
 * @date 2018年7月4日 下午4:00:17
 * 
 */
public class HtmlEscapeTag extends SimpleTagSupport {
    private String filter(String message) {

        if (message == null) {
            return (null);
        }
        // 定义一个char数组 长度为message.length
        char content[] = new char[message.length()];
        // copy string --> char []
        message.getChars(0, message.length(), content, 0);
        StringBuilder result = new StringBuilder(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
            case '<':
                result.append("&lt;");
                break;
            case '>':
                result.append("&gt;");
                break;
            case '&':
                result.append("&amp;");
                break;
            case '"':
                result.append("&quot;");
                break;
            default:
                result.append(content[i]);
            }
        }
        // 重构了message
        return (result.toString());
    }

    @Override
    public void doTag() throws JspException, IOException {
        StringWriter sw = new StringWriter();
        // 将标签体中的内容先输出到StringWriter流
        this.getJspBody().invoke(sw);
        // 得到标签体中的内容
        String content = sw.getBuffer().toString();
        // 转义标签体中的html代码
        content = filter(content);
        // 输出转义后的content
        this.getJspContext().getOut().write(content);
    }
}
