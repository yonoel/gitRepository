package com.web.util;

import java.util.List;

/**
 * @ClassName: FunctionTag
 * @Description: TODO(������һ�仰��������������)
 * @date 2018��7��5�� ����10:19:18
 * 
 */
public class FunctionTag {
    public static void main(String[] args) {
        System.out.println(filter("avafva<s>"));
    }

    public static String filter(String message) {
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

    public static Integer bbq(@SuppressWarnings("rawtypes") List list) {

        return list.size();
    }

}
