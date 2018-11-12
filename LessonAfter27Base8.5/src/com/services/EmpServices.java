package com.services;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.EmpMpperInterface;
import com.github.pagehelper.PageHelper;

import javabean.Emp;

/**
 * @ClassName: EmpServices
 * @Description: 测试分页用的
 * @date 2018年7月18日 上午11:14:50
 * 
 */
public class EmpServices {
    public static void main(String[] args) {
        EmpServices services = new EmpServices();
        Map map = new HashMap<String, Integer>();
        System.out.println("------------");
    }

    private EmpMpperInterface mapper;

    public EmpServices() {
        super();
        String name = "MyBatisCfg.xml";
        InputStream inputStream = AreaServices.class.getClassLoader().getResourceAsStream(name);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        this.mapper = factory.openSession().getMapper(EmpMpperInterface.class);
    }

    public List<Emp> queryPage(String pagenum) {

        PageHelper.startPage(Integer.parseInt(pagenum), 10);
        return mapper.queryAll();
    }

    public int countPages() {
        return PageHelper.startPage(1, 10).doSelectPageInfo(() -> mapper.queryAll()).getPages();
    }
}
