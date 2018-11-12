package com.igeek.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @ClassName: WebMvcConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月3日 上午7:57:17
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.igeek.controller")
@EnableScheduling // 提供了基于多种规则的任务调度功能
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // 注册response部分，实现httpmessa接口
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // FastJsonHttpMessageConverter converter = new
        // FastJsonHttpMessageConverter();
        // converter.setDateFormat("yyyy-MM-dd");

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        converters.add(converter);
    }

    class ObjectMapper {

    }
    // 注册参数解析器,这就是为啥通过注解就拿取参的原因

    // Handle HTTP GET requests for /resources/** by efficiently serving
    // static resources under ${webappRoot}/resources/
    // 资源处理器，这样就跳过了dispatcher的配置
    /*
     * @Override public void addResourceHandlers(ResourceHandlerRegistry
     * registry) {
     * registry.addResourceHandler("/resources/**").addResourceLocations(
     * "/resources/");
     * 
     * }
     */

    // 视图控制器，使得“/”为view名称为home
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }

    // 视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/views/", ".jsp");
        
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper pathHelper = new UrlPathHelper();
        // For @MatrixVariable's default is true
        pathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(pathHelper);
    }

    // 註冊异步支持，设置时间等待
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(3000);
        // 注册回调拦截器
        configurer.registerCallableInterceptors();
    }

}
