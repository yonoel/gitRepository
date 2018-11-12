package org.springframework.samples.context;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.samples.configs.PropertiesConfig;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @ClassName: AppConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月4日 下午1:20:37
 * 
 */
@Configuration
@ComponentScan(basePackages = "org.springframework.samples.configs")
@PropertySource("classpath:config.properties")
public class AppConfig {
  

    @Bean
    public DataSource dataSource(@Autowired PropertiesConfig propertiesConfig) {
        System.out.println(propertiesConfig);     
        DataSource dataSource = new DruidDataSource();
        System.out.println("这里是DataSource:" + propertiesConfig);
        return dataSource;
    }
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Autowired DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        Properties properties = new Properties();
        properties.setProperty("supportMethodsArguments", "true");

        return sessionFactory;
    }
    @Bean("mapperScannerConfigurer")
    public org.mybatis.spring.mapper.MapperScannerConfigurer MapperScannerConfigurer()
            throws Exception {
        org.mybatis.spring.mapper.MapperScannerConfigurer mapperScannerConfigurer = new org.mybatis.spring.mapper.MapperScannerConfigurer();
       
        mapperScannerConfigurer.setBasePackage("com.igeek.mvc.dao");
        // 注意，这里必须用beanId来注入，否则SqlSessionFactoryBean会提前实例化，导致读不到properties文件
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }
   /* @Bean("mapperScannerConfigurer")
    public tk.mybatis.spring.mapper.MapperScannerConfigurer MapperScannerConfigurer()
            throws Exception {
        tk.mybatis.spring.mapper.MapperScannerConfigurer mapperScannerConfigurer = new tk.mybatis.spring.mapper.MapperScannerConfigurer();
       
        mapperScannerConfigurer.setBasePackage("com.igeek.mvc.dao");
        // 注意，这里必须用beanId来注入，否则SqlSessionFactoryBean会提前实例化，导致读不到properties文件
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }*/
    
    @Bean("sqlsession")
    public SqlSession SqlSession(SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
        return sqlSessionFactoryBean.getObject().openSession();
    }
}
