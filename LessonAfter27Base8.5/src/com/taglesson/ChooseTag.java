package com.taglesson;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @ClassName: ChooseTag
 * @Description: when��ǩ��otherwise��ǩ�ĸ���ǩ
 * @date 2018��7��4�� ����3:27:53
 * 
 */
public class ChooseTag extends SimpleTagSupport {
    /**
     * ����һ��boolean���͵����ԣ����������ڱ�ʶ�ñ�ǩ�µ�ĳһ���ӱ�ǩ�Ƿ��Ѿ�ִ�й��ˣ�
     * ����ñ�ǩ�µ�ĳһ���ӱ�ǩ�Ѿ�ִ�й��ˣ��ͽ�����������Ϊtrue
     */
    private boolean isExecute;

    @Override
    public void doTag() throws JspException, IOException {
        // �����ǩ���е�����
        this.getJspBody().invoke(null);
    }

    public boolean isExecute() {
        return isExecute;
    }

    public void setExecute(boolean isExecute) {
        this.isExecute = isExecute;
    }
}
