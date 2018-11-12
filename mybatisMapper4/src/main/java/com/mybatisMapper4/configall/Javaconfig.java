package com.mybatisMapper4.configall;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatisMapper4.dao.CountryMapper;
import com.mybatisMapper4.domain.Country;

import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

/**
 * @ClassName: Javaconfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月20日 上午8:06:36
 * 
 */
public class Javaconfig {
    public static void main(String[] args) {
        String name = "MyBatisCfg.xml";
        InputStream inputStream = Javaconfig.class.getClassLoader().getResourceAsStream(name);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        MapperHelper mapperHelper = new MapperHelper();
        Config config = new Config();

        // 主键自增回写方法,默认值MYSQL,详细说明请看文档
        // config.setIDENTITY("MYSQL");
        // // 支持getter和setter方法上的注解
        // config.setEnableMethodAnnotation(true);
        // // 设置 insert 和 update 中，是否判断字符串类型!=''
        // config.setNotEmpty(true);
        // // 校验Example中的类型和最终调用时Mapper的泛型是否一致
        // config.setCheckExampleEntityClass(true);
        // // 启用简单类型
        // config.setUseSimpleType(true);
        // // 枚举按简单类型处理
        // config.setEnumAsSimpleType(true);
        // // 自动处理关键字 - mysql
        // config.setWrapKeyword("`{0}`");
        // 设置配置
        mapperHelper.setConfig(config);
        // 配置 mapperHelper 后，执行下面的操作
        mapperHelper.processConfiguration(session.getConfiguration());

        CountryMapper countryMapper = session.getMapper(CountryMapper.class);
        // 从 MyBatis 或者 Spring 中获取 countryMapper，然后调用 selectAll 方法
        List<Country> list = countryMapper.selectAll();
        Country record = new Country();
        record.setId(1);
        list = countryMapper.select(record);
        Example example = new Example(Country.class);
        Criteria criteria = example.createCriteria();
        criteria.orLessThanOrEqualTo("id", 20);
        
        list = countryMapper.selectByExample(example);
        System.out.println(list.size());
    }
}
