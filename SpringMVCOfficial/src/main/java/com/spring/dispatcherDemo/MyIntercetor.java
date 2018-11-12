package com.spring.dispatcherDemo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: MyIntercetor
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月13日 上午10:20:03
 * 
 */
public class MyIntercetor implements HandlerInterceptor {
    private Logger log = LogManager.getLogger();

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        log.info("1---afterCompletion方法-----DispatcherServlet完全处理完请求后被调用，往往执行一些资源清理动作");
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        log.info("1---postHandle方法----------Controller方法后");
    }

    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
        log.info("1---preHandle方法-----------Controller方法前");
        // 如返回为false的时候，拦截器可阻止方法的调用 ，默认返回false
        // return false;
        return true;
    }
}
