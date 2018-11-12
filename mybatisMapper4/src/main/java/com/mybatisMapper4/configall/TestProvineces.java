package com.mybatisMapper4.configall;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatisMapper4.dao.AreaMapper;
import com.mybatisMapper4.dao.ProvinceMapper;
import com.mybatisMapper4.domain.Province;

import tk.mybatis.mapper.mapperhelper.MapperHelper;

/**
 * @ClassName: TestProvineces
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月8日 下午4:06:51
 * 
 */
public class TestProvineces {
    public static void main(String[] args) {
        String name = "MyBatisCfg.xml";
        InputStream inputStream = Javaconfig.class.getClassLoader().getResourceAsStream(name);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();

        MapperHelper mapperHelper = new MapperHelper();
        mapperHelper.processConfiguration(session.getConfiguration());
        Province province = session.getMapper(ProvinceMapper.class).queryTest("1");
        System.out.println(province);

        // ProvinceMapper mapper = (ProvinceMapper)
        // session.getMapper(ProvinceMapper.class);
        // mapper.queryTest();
    }
}
