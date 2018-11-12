package com.taglesson;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @ClassName: WhenTag
 * @Description: TODO(������һ�仰��������������)
 * @date 2018��7��4�� ����3:28:53
 * 
 */
public class WhenTag extends SimpleTagSupport {
    /**
     * test���ԣ�������ֵΪtrueʱ�������ǩ���е�����
     */
    private boolean flag;

    @Override
    public void doTag() throws JspException, IOException {
        // ��ȡ��ǩ�ĸ���ǩ ����ǩ����Ƕ�׵���һ���ǩ����дҳ��ʱ�Ѿ�д��
        ChooseTag parentTag = (ChooseTag) this.getParent();
        if (flag == true && parentTag.isExecute() == false) {
            // �����ǩ���е�����
            this.getJspBody().invoke(null);
            // ������ǩ��isExecute��������Ϊtrue�����߸���ǩ����(when��ǩ)�Ѿ�ִ�й���
            parentTag.setExecute(true);
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
