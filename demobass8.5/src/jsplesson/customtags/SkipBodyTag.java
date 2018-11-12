package jsplesson.customtags;

import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @ClassName: SkipBodyTag
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月4日 上午10:46:23
 * 
 */
public class SkipBodyTag extends TagSupport {
    @Override
    public int doStartTag() {
        // 如果这个方法返回EVAL_BODY_INCLUDE，则执行标签体，如果返回SKIP_BODY，则不执行标签体
        // return Tag.EVAL_BODY_INCLUDE;
        return Tag.EVAL_BODY_INCLUDE;
    }
}
