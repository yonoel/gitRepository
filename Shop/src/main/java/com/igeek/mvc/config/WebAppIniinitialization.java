package com.igeek.mvc.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @ClassName: WebAppIniinitialization
 * @Description: web应用初始化的配置继承了注解配置的dispatcher类 初始化servlet
 * @date 2018年8月3日 上午7:57:04
 * 
 */
public class WebAppIniinitialization extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * @Title: getRootConfigClasses
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getRootConfigClasses()
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // 这里就相当于加载了其他上下文的配置
        return new Class[] { RootConfig.class,AppConfig.class };
    }

    /**
     * @Title: getServletConfigClasses
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getServletConfigClasses()
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        // 这里就相当于加载了Dispathcer，初始化了servlet
        return new Class[] { WebMvcConfig.class };
    }

    /**
     * @Title: getServletMappings
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletMappings()
     */
    @Override
    protected String[] getServletMappings() {
        return  new String[] { "/" };
    }
    
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {  };
    }

}
