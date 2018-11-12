package jsplesson.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @ClassName: SimpleTagChild
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月4日 下午1:17:52
 * 
 */
public class SimpleTagChild extends SimpleTagSupport {
    /*
     * 简单标签使用这个方法就可以完成所有的业务逻辑
     * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
     * 重写doTag方法，控制标签体是否执行
     */
    @Override
    public void doTag() {
            // 什么都不做
//        try {
//           try {
//            getJspBody().invoke(null);
//        } catch (JspException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        // 做循环
//        for (int i = 0; i < 5; i++) {
//            try {
//                getJspBody().invoke(null);
//            } catch (JspException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
        // 改写内容
        // 抛出异常
        try {
            throw new SkipPageException("我随便写的");
        } catch (SkipPageException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
