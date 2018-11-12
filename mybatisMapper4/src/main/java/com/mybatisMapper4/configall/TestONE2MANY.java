package com.mybatisMapper4.configall;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatisMapper4.dao.CategoryMapper;
import com.mybatisMapper4.dao.ProductMapper;
import com.mybatisMapper4.domain.Category;
import com.mybatisMapper4.domain.Product;

import tk.mybatis.mapper.mapperhelper.MapperHelper;

/**
 * @ClassName: TestONE2MANY
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月31日 下午7:09:15
 * 
 */
public class TestONE2MANY {
    public static void main(String[] args) {
        String name = "MyBatisCfg.xml";
        InputStream inputStream = Javaconfig.class.getClassLoader().getResourceAsStream(name);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        
        MapperHelper mapperHelper = new MapperHelper();
        mapperHelper.processConfiguration(session.getConfiguration());
        ProductMapper productMapper = session.getMapper(ProductMapper.class);
       
       // productMapper.selectAll().forEach(System.out::print);
        CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
        Category category = categoryMapper.selectByPrimaryKey("1");
        System.out.println(category);
        Product p1 = productMapper.queryProductBykey("1");
        System.out.println(p1);
        Product p2 = productMapper.queryProductBykey2("1");
        System.out.println(p2);
        Product p3 = productMapper.selectByPrimaryKey("1");
        System.out.println(p3);
        Product p4 = productMapper.queryProductBykey3("1");
        System.out.println(p4);
    }
}
