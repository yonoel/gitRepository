package com.igeek.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;

/**
 * @ClassName: AppConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月3日 下午4:09:40
 * 
 */
@ComponentScan(basePackages = { "com.igeek.config", "com.igeek.serviceImpl"})
@Configuration
@PropertySource(value = { "classpath:application.properties", "classpath:redis.properties" })
@EnableTransactionManagement
public class AppConfig {

    // 用${}占位符注入属性，这个bean是必须的，这个就是占位bean,另一种方式是不用value直接用Envirment变量直接getProperty('key')
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean("dataSource")
    public static DataSource dataSource(@Autowired PropertyConfig propertyConfig) {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(propertyConfig.getUrl());
        dataSource.setUsername(propertyConfig.getUser());
        dataSource.setPassword(propertyConfig.getPassword());
        dataSource.setDriverClassName(propertyConfig.getDriver());
        dataSource.setInitialSize(propertyConfig.getInitialSize());
        dataSource.setMaxActive(propertyConfig.getMaxActive());
        System.out.println("这里是DataSource:" + propertyConfig);
        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Autowired DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        Interceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("supportMethodsArguments", "true");
        interceptor.setProperties(properties);
        sessionFactory.setPlugins(new Interceptor[] { interceptor });

        return sessionFactory;
    }

    @Bean("mapperScannerConfigurer")
    public tk.mybatis.spring.mapper.MapperScannerConfigurer MapperScannerConfigurer() throws Exception {
        tk.mybatis.spring.mapper.MapperScannerConfigurer mapperScannerConfigurer = new tk.mybatis.spring.mapper.MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.igeek.mapper");
        // 注意，这里必须用beanId来注入，否则SqlSessionFactoryBean会提前实例化，导致读不到properties文件
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }

    @Bean("sqlsession")
    public SqlSession SqlSession(SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
        return sqlSessionFactoryBean.getObject().openSession();
    }

}
