package com.web.util;

import java.util.List;

/**
 * @ClassName: FunctionTag
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月5日 上午10:19:18
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
        return result.toString();

    }

    public static Integer bbq(@SuppressWarnings("rawtypes") List list) {

        return list.size();
    }

}
