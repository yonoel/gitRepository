package com.igeek.dao.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import tk.mybatis.mapper.mapperhelper.MapperHelper;

/**
 * @ClassName: DaoUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月25日 下午6:31:32
 * 
 */
public class DaoUtils {
    public static SqlSession getSqlSession() {
        String name = "MyBatisConfig.xml";
        InputStream inputStream = DaoUtils.class.getClassLoader().getResourceAsStream(name);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        MapperHelper mapperHelper = new MapperHelper();
        // Config config = new Config();
        // 设置配置
        // mapperHelper.setConfig(config);
        // 配置 mapperHelper 后，执行下面的操作
        mapperHelper.processConfiguration(session.getConfiguration());

        return session;
    }
}
