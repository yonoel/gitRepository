package jsplesson.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

/**  
* @ClassName: ModifyBody  
* @Description: TODO(������һ�仰��������������)
* @date 2018��7��4�� ����11:11:00    
*    
*/
public class ModifyBody extends BodyTagSupport{
    /* ����doStartTag()��������EVAL_BODY_BUFFERED
     * @see javax.servlet.jsp.tagext.BodyTagSupport#doStartTag()
     */
    @Override
    public int doStartTag() throws JspException {
        // body��ִ����д��
        return BodyTag.EVAL_BODY_BUFFERED;
    }
    
    @Override
    public int doEndTag() throws JspException {
        
        //this.getBodyContent()�õ������ǩ���bodyContent����
        BodyContent bodyContent = this.getBodyContent();
        //�õ���ǩ�� ��content��String�ĸ�ʽ����
       
        String content = bodyContent.getString();
        //�޸ı�ǩ����������ݣ�����ǩ�������ת���ɴ�д
        String result = content.toUpperCase();
        try {
            //����޸ĺ������
            this.pageContext.getOut().write(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // ִ��ҳ��
        return Tag.EVAL_PAGE;
    }
}
