package formVerify.web.Util;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @ClassName: WebUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月3日 下午1:05:18
 * 
 */
public class WebUtils {
    /**
     * 将request对象转换成T对象
     * 
     * @param request
     * @param clazz
     * @return
     */
    public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz) {
        try {
            T bean = clazz.newInstance();
            Map<String, String[]> properties = request.getParameterMap();
            BeanUtils.populate(bean, properties);
            
            // Enumeration<String> e = request.getParameterNames();
            // while (e.hasMoreElements()) {
            // String name = (String) e.nextElement();
            // String value = request.getParameter(name);
            // BeanUtils.setProperty(bean, name, value);
            // }
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成UUID
     * 
     * @return
     */
    public static String makeId() {
        return UUID.randomUUID().toString();
    }
}
