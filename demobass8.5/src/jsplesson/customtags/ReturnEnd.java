package jsplesson.customtags;

import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @ClassName: ReturnEnd
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月4日 上午11:01:57
 * 
 */
public class ReturnEnd extends TagSupport {
    @Override
    public int doEndTag() {
        //如果这个方法返回EVAL_PAGE，则执行标签余下的jsp页面，如果返回SKIP_PAGE，则不执行余下的jsp
        return Tag.EVAL_PAGE;
    }
}
