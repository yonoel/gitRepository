package jsplesson.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @ClassName: SimpleTagChild
 * @Description: TODO(������һ�仰��������������)
 * @date 2018��7��4�� ����1:17:52
 * 
 */
public class SimpleTagChild extends SimpleTagSupport {
    /*
     * �򵥱�ǩʹ����������Ϳ���������е�ҵ���߼�
     * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
     * ��дdoTag���������Ʊ�ǩ���Ƿ�ִ��
     */
    @Override
    public void doTag() {
            // ʲô������
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
        // ��ѭ��
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
        // ��д����
        // �׳��쳣
        try {
            throw new SkipPageException("�����д��");
        } catch (SkipPageException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
