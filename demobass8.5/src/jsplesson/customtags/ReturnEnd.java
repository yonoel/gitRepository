package jsplesson.customtags;

import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @ClassName: ReturnEnd
 * @Description: TODO(������һ�仰��������������)
 * @date 2018��7��4�� ����11:01:57
 * 
 */
public class ReturnEnd extends TagSupport {
    @Override
    public int doEndTag() {
        //��������������EVAL_PAGE����ִ�б�ǩ���µ�jspҳ�棬�������SKIP_PAGE����ִ�����µ�jsp
        return Tag.EVAL_PAGE;
    }
}
