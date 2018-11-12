package com.spring.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.igeek.domain.Emp;

/**
 * @ClassName: EmpServicesTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月17日 上午7:39:31
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:Spring-mybatis.xml" })
public class EmpServicesTest {

    @Resource
    private EmpServicesImp service;

    /**
     * Test method for
     * {@link com.igeek.services.EmpServicesImp#queryEmpByNo(int)}.
     */
    @Test
    public void testQueryEmpByNo() {
        // Map<String, Object> map = service.queryAll("1");
        // map.entrySet().forEach(System.out::println);
        // Page<Emp> pages = (Page<Emp>) map.get("success");
        // Assert.assertEquals(6, pages.getPages());
        // List<Emp> list = pages.getResult();
        // list.forEach(System.out::println);
//        Example empExample = new Example(Emp.class);
        
        Emp emp = new Emp();
        // // emp.setEmpNo(20);
        emp.setEname("admin");
        emp.setPassword(123456);
        Map<String, Object> map = service.queryEmp(emp);
        System.out.println(map.get("flag"));
        Emp emp2 = (Emp) map.get("emp");
        System.out.println(emp2);
        // String empstr = map.get("emp").toString();
        // System.out.println(empstr);
        // Map<String, Object> map = service.insertEmp(emp);

    }

    /**
     * Test method for {@link com.igeek.services.EmpServicesImp#queryAll()}.
     */
    @Test
    public void testQueryAll() {
    }

    /**
     * Test method for
     * {@link com.igeek.services.EmpServicesImp#insertEmp(com.com.igeek.domain.Emp)}.
     */
    @Test
    public void testInsertEmp() {
    }

    /**
     * Test method for {@link com.igeek.services.EmpServicesImp#deleteEmp(int)}.
     */
    @Test
    public void testDeleteEmp() {
    }

    /**
     * Test method for
     * {@link com.igeek.services.EmpServicesImp#updateEmp(com.com.igeek.domain.Emp)}.
     */
    @Test
    public void testUpdateEmp() {
    }

}
