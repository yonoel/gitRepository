package com.taglesson;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @ClassName: ForEachTag
 * @Description: 开发foreach
 * @date 2018年7月4日 下午3:45:36
 * 
 */
public class ForEachTag extends SimpleTagSupport {
    // jsp片段给我一个list
    // 1。获取list2.list输出
    private List<String> list;
    // 还需要list下每一个字段
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
                // 每一次都让page执行
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
