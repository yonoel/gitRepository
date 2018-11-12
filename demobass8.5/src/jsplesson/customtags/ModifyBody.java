package jsplesson.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

/**  
* @ClassName: ModifyBody  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年7月4日 上午11:11:00    
*    
*/
public class ModifyBody extends BodyTagSupport{
    /* 控制doStartTag()方法返回EVAL_BODY_BUFFERED
     * @see javax.servlet.jsp.tagext.BodyTagSupport#doStartTag()
     */
    @Override
    public int doStartTag() throws JspException {
        // body的执行重写流
        return BodyTag.EVAL_BODY_BUFFERED;
    }
    
    @Override
    public int doEndTag() throws JspException {
        
        //this.getBodyContent()得到代表标签体的bodyContent对象
        BodyContent bodyContent = this.getBodyContent();
        //拿到标签体 把content以String的格式返回
       
        String content = bodyContent.getString();
        //修改标签体里面的内容，将标签体的内容转换成大写
        String result = content.toUpperCase();
        try {
            //输出修改后的内容
            this.pageContext.getOut().write(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 执行页面
        return Tag.EVAL_PAGE;
    }
}
