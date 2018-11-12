package com.taglesson;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @ClassName: ForEachTag
 * @Description: ����foreach
 * @date 2018��7��4�� ����3:45:36
 * 
 */
public class ForEachTag extends SimpleTagSupport {
    // jspƬ�θ���һ��list
    // 1����ȡlist2.list���
    private List<String> list;
    // ����Ҫlist��ÿһ���ֶ�
    private String var;

    /**
     * @return the var
     */
    public String getVar() {
        return var;
    }

    /**
     * @param var
     *            the var to set
     */
    public void setVar(String var) {
        this.var = var;
    }

    /**
     * @return the list
     */
    public List<String> getList() {
        return list;
    }

    /**
     * @param list
     *            the list to set
     */
    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public void doTag() {
        JspContext context = this.getJspContext();
        list.forEach(p -> {
            context.setAttribute(var, p);
            try {
                // ÿһ�ζ���pageִ��
                this.getJspBody().invoke(null);
            } catch (JspException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }
}
