package com.taglesson;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @ClassName: HtmlEscapeTag
 * @Description: htmlת���ǩ
 * @date 2018��7��4�� ����4:00:17
 * 
 */
public class HtmlEscapeTag extends SimpleTagSupport {
    private String filter(String message) {

        if (message == null) {
            return (null);
        }
        // ����һ��char���� ����Ϊmessage.length
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
        // �ع���message
        return (result.toString());
    }

    @Override
    public void doTag() throws JspException, IOException {
        StringWriter sw = new StringWriter();
        // ����ǩ���е������������StringWriter��
        this.getJspBody().invoke(sw);
        // �õ���ǩ���е�����
        String content = sw.getBuffer().toString();
        // ת���ǩ���е�html����
        content = filter(content);
        // ���ת����content
        this.getJspContext().getOut().write(content);
    }
}
