package jsplesson.customtags;

import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @ClassName: SkipBodyTag
 * @Description: TODO(������һ�仰��������������)
 * @date 2018��7��4�� ����10:46:23
 * 
 */
public class SkipBodyTag extends TagSupport {
    @Override
    public int doStartTag() {
        // ��������������EVAL_BODY_INCLUDE����ִ�б�ǩ�壬�������SKIP_BODY����ִ�б�ǩ��
        // return Tag.EVAL_BODY_INCLUDE;
        return Tag.EVAL_BODY_INCLUDE;
    }
}
