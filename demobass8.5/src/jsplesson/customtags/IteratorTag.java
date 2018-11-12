package jsplesson.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @ClassName: IteratorTag
 * @Description: TODO(������һ�仰��������������)
 * @date 2018��7��4�� ����11:04:47
 * 
 */
public class IteratorTag extends TagSupport {
    int x = 5;

    @Override
    public int doStartTag() throws JspException {
        return Tag.EVAL_BODY_INCLUDE;
    }

    /*
     * ����doAfterBody()�����ķ���ֵ�� ��������������EVAL_BODY_AGAIN�� ��web��������ִ��һ�α�ǩ�壬
     * �������ƣ�һֱִ�е�doAfterBody��������SKIP_BODY�����ǩ��Ų����ظ�ִ�С�
     * 
     * @see javax.servlet.jsp.tagext.TagSupport#doAfterBody()
     */
    @Override
    public int doAfterBody() throws JspException {
        x--;
        if (x > 0) {
            return IterationTag.EVAL_BODY_AGAIN;
        } else {
            return IterationTag.SKIP_BODY;
        }
    }
}
