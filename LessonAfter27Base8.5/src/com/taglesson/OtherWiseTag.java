package com.taglesson;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @ClassName: OtherWiseTag
 * @Description: TODO(������һ�仰��������������)
 * @date 2018��7��4�� ����3:31:20
 * 
 */
public class OtherWiseTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        // ��ȡ��ǩ�ĸ���ǩ
        ChooseTag parentTag = (ChooseTag) this.getParent();
        // �������ǩ�µ�when��ǩû��ִ�й�
        if (parentTag.isExecute() == false) {
            // �����ǩ���е�����
            this.getJspBody().invoke(null);
            // ���ø���ǩ��isExecute����Ϊtrue�����߸���ǩ����(otherwise��ǩ)�Ѿ�ִ�й���
            parentTag.setExecute(true);
        }
    }
}
