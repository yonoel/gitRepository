package com.web.util;

/**
 * @ClassName: HtmlFilter
 * @Description: ת��Ĺ���
 * @date 2018��7��5�� ����9:40:03
 * 
 */
public class HtmlFilter {
    public static void main(String[] args) {

    }

    public static String abc(String message) {
        if (message == null) {
            return null;
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

        return result.toString();
    }
}
